$(document).ready(function () {
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
                        $('table tbody').empty();
                        //rebuildTable(languages);
                        resolve(languages);
                    }
                },
                error: function (xhr, status, error) {
                    console.log("Ошибка запроса: " + xhr.status);
                    reject(error);
                }
            });
        });
        //return false;
    }

    function rebuildTable(JSONlanguageDTOs) {
        // var ArraylanguageDTOs = JSON.parse(JSONlanguageDTOs);
        $("languagesTBody").empty();
        if (Array.isArray(JSONlanguageDTOs)) {
            //alert("languageDTOs is Array")
            //}else alert("languageDTOs NOT ARRAY!")
            JSONlanguageDTOs.forEach(function (dto) {
                var tr = $("<tr>");
                var td1 = $("<td>")
                    .attr("id", "languageCodeText" + dto.languageId)
                    .text(dto.languageCode);
                var td2 = $("<td>")
                    .attr("id", "languageName" + dto.languageId)
                    .text(dto.languageName);
                var td3 = $("<td>")
                    .append($("<button>")
                        .attr("id", "editBtn" + dto.languageId)
                        .attr("type", "click")
                        .text("Редактировать"))
                    .append($("<button>")
                        .attr("id", "deleteBtn" + dto.languageId)
                        .attr("type", "click")
                        .text("Удалить"))
                    .append($("<button>")
                        .attr("id", "saveBtn" + dto.languageId)
                        .attr("type", "click")
                        .text("Сохранить"))
                    .append($("<button>")
                        .attr("id", "cancelBtn" + dto.languageId)
                        .attr("type", "click")
                        .text("Отменить"));

                tr.append(td1, td2, td3);
                var markup = tr.prop('outerHTML');
                tableBody = $("table tbody");
                tableBody.append(markup);
            })
        } else alert("languageDTOs NOT ARRAY!")
    }

});