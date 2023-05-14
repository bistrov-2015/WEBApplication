$(document).ready(function () {
    console.log(typeof $)
    doAjaxRequestToGetallDataAboutLanguages()
        .then(function (languages) {
            rebuildTable(languages);
        })
        .catch(function (error) {
            alert(error);
        });
    $('#addNewLanguageInToDictionary').click(doAjaxRequestToAddNewLanguage);

    function doAjaxRequestToAddNewLanguage() {
        var newLanguageCode = $('#inputedNewLanguageCode').val();
        var newLanguageName = $('#inputedNewLanguageName').val();

        if (newLanguageCode.length === 0) {
            alert("Введите код языка для добавления!")
            return false;
        } else {
            if (newLanguageName.length === 0) {
                alert("Введите имя языка для добавления!")
                return false;
            } else {

                $.ajax({
                    url: 'http://localhost:8080/addToDictionary/addNewLanguage',
                    type: 'POST',
                    dataType: 'json',
                    contentType: 'application/json',
                    data: JSON.stringify({
                        languageCode: newLanguageCode,
                        languageName: newLanguageName,
                    }),
                    error: {
                        alert(message) {
                            message = "Request Error!"
                        }
                    },
                    success: function (data) {

                        if (data.infoMessageAboutAddNewLanguageResult.length === 0) {
                            alert('Ошибка на сервере, в ответ получен null!')
                        } else {
                            alert(data.infoMessageAboutAddNewLanguageResult);
                        }
                        /*rebuildTable(doAjaxRequestToGetallDataAboutLanguages());*/
                        $('table tbody').empty();
                        doAjaxRequestToGetallDataAboutLanguages()
                            .then(function (languages) {
                                rebuildTable(languages)
                            })
                            .catch(function (error) {
                                console.error(error);
                            });
                    }

                });
                return false;
            }
        }
    }


    function doAjaxRequestToGetallDataAboutLanguages() {
        return new Promise(function (resolve, reject) {
            $.ajax({
                url: 'http://localhost:8080/serchRequest/getAllRowsFromLanguages',
                type: 'GET',
                dataType: "json",

                success: function (response) {
                    if (response.length === 0) {
                        alert("Нет данных, запрос вернул пустой список.");
                    } else {
                        var languages = response.map(function (dto) {
                            return {
                                languageId: dto.languageId,
                                languageCode: dto.languageCode,
                                languageName: dto.languageName,
                            };
                        });
                        resolve(languages);
                    }
                },
                error: function (xhr, status, error) {
                    console.log("Ошибка запроса: " + xhr.status);
                    reject(error);
                }
            });
        });
    }

    function deleteSubmit(){

    }

    function deleteLanguage(languageId) {
        //var languageId = btnId.substring(7); // удаляем префикс "deleteBtn" из идентификатора кнопки
        //alert("delete called" + languageId)
        var result = confirm("Вы действительно хотите удалить эту запись?");
        if (result) {
            $.ajax({
                url: 'http://localhost:8080/deleteRow/deleteLanguage',
                type: 'POST',
                dataType: 'json',
                contentType: 'application/json',
                data: JSON.stringify({
                    languageId: languageId,
                }),
                success: function (response) {
                    alert(response.resultMessage);
                    $('table tbody').empty();
                    doAjaxRequestToGetallDataAboutLanguages()
                        .then(function (languages) {
                            rebuildTable(languages)
                        })
                        .catch(function (error) {
                            console.error(error);
                        });
                },
                error: function (xhr, status, error) {
                    console.log("Ошибка запроса: " + xhr.status);

                }

            });
        } else {
            return;
        }
        //return false;
    }


    function rebuildTable(ArraylanguageDTOs) {
        $('table tbody').empty();
        if (Array.isArray(ArraylanguageDTOs)) {
            ArraylanguageDTOs.forEach(function (dto) {
                var tr = $("<tr>");
                var td1 = $("<td>")
                    .attr("id", "languageCodeText" + dto.languageId)
                    .text(dto.languageCode);
                var td2 = $("<td>")
                    .attr("id", "languageName" + dto.languageId)
                    .text(dto.languageName);
                var deleteBtn = $("<button>")
                    .attr("id", "deleteBtn" + dto.languageId)
                    .attr("type", "button")
                    .text("Удалить")
                    .click(function () {
                            var languageId = dto.languageId;
                            deleteLanguage(languageId);
                        });

                /*$(document).on('click', '#deleteBtn' + dto.languageId, function () {
                    deleteLanguage(dto.languageId);
                });*/
                var editBtn = $("<button>")
                    .attr("id", "editBtn" + dto.languageId)
                    .attr("type", "button")
                    .text("Редактировать")
                    .click(function () {
                        var languageId = dto.languageId;
                        editLanguage(languageId);
                    });

                var saveBtn = $("<button>")
                    .attr("id", "saveBtn" + dto.languageId)
                    .attr("type", "button")
                    .text("Сохранить")
                    .click(function () {
                        var languageId = dto.languageId;
                        saveLanguage(languageId);
                    });

                var cancelBtn = $("<button>")
                    .attr("id", "cancelBtn" + dto.languageId)
                    .attr("type", "button")
                    .text("Отменить")
                    .click(function () {
                        var languageId = dto.languageId;
                        cancelChanges(languageId);
                    });

                tr.append(td1)
                    .append(td2)
                    .append(deleteBtn)
                    .append(editBtn)
                    .append(saveBtn)
                    .append(cancelBtn);
                $('table tbody').append(tr);
                saveBtn.hide();
                cancelBtn.hide();
            });

        }
    }

    /*$(document).on('click', '[id^="deleteBtn"]', function () {
                var languageId = $(this).attr('id').replace('deleteBtn', '');
                deleteLanguage(languageId);
            });*/
    /*$('table tbody').off('click', '[id^="deleteBtn"]').on('click', '[id^="deleteBtn"]', function () {
                    var languageId = $(this).attr('id').replace('deleteBtn', '');
                    deleteLanguage(languageId);
                });*/



    function editLanguage(languageId) {
        //alert("edit called")
        //var languageCode = $('#languageCodeText' + languageId).text();
        var languageName = $('#languageName' + languageId).text();

        /*$('#languageCodeText' + languageId).empty()
            .append($('<input>')
                .attr('type', 'text')
                .attr('id', 'languageCodeInput' + languageId)
                .val(languageCode));*/

        $('#languageName' + languageId).empty()
            .append($('<input>')
                .attr('type', 'text')
                .attr('id', 'languageNameInput' + languageId)
                .val(languageName));

        $('#editBtn' + languageId).hide();
        $('#deleteBtn' + languageId).hide();
        $('#saveBtn' + languageId).show();
        $('#cancelBtn' + languageId).show();
    }

    function saveLanguage(languageId) {
        //alert("save called")
        //var languageCode = $('#languageCodeInput' + languageId).val();
        var languageCode = $('#languageCodeText' + languageId).text();// контроллер ждёт объект languageDTO с полями id, code, Name
        var languageName = $('#languageNameInput' + languageId).val();

        /*if (languageCode.length === 0) {
            alert("Введите код языка для сохранения!")
            return false;
        } else {*/
            if (languageName.length === 0) {
                alert("Введите имя языка для сохранения!")
                return false;
            } else {
                $.ajax({
                    url: 'http://localhost:8080/updateRow/updateLanguage',
                    type: 'PUT',
                    dataType: 'json',
                    contentType: 'application/json',
                    data: JSON.stringify({
                        languageId: languageId,
                        languageCode: languageCode,
                        languageName: languageName,
                    }),
                    success: function (response) {
                        //alert(response);
                        $('table tbody').empty();
                        doAjaxRequestToGetallDataAboutLanguages()
                            .then(function (languages) {
                                rebuildTable(languages)
                            })
                            .catch(function (error) {
                                console.error(error);
                            });
                    },
                    error: function (xhr, status, error) {
                        console.log("Ошибка запроса: " + xhr.status);
                    }
                });
            }
        //}
    }

    function cancelChanges(languageId) {
        //alert("cancel called")
        var languageCode = $('#languageCodeInput' + languageId).val();
        var languageName = $('#languageNameInput' + languageId).val();

        $('#languageCodeInput' + languageId).replaceWith($('<span>')
            .attr('id', 'languageCodeText' + languageId)
            .text(languageCode));

        $('#languageNameInput' + languageId).replaceWith($('<span>')
            .attr('id', 'languageName' + languageId)
            .text(languageName));


        $('#editBtn' + languageId).show();
        $('#deleteBtn' + languageId).show();
        $('#saveBtn' + languageId).hide();
        $('#cancelBtn' + languageId).hide();
    }

});