$(document).ready(function () {

    function Menu1() {
        const elements = document.getElementsByClassName("languagesListItems1");
        for (i = 0; i < elements.length; i++) {
            elements[i].addEventListener('mousedown', showMenu);
            elements[i].addEventListener('mouseleave', hideMenu);
        }

        function showMenu() {
            if (this.children.length > 1) {
                this.children[1].style.height = 'auto';
                this.children[1].style.opacity = '1';
                this.children[1].style.overflow = 'visible';
            }
        }

        function hideMenu() {
            if (this.children.length > 1) {
                this.children[1].style.height = '0';
                this.children[1].style.opacity = '0';
                this.children[1].style.overflow = 'hidden';
            }
        }
    }

    function Menu2() {
        const elements = document.getElementsByClassName("languagesListItems2");
        for (i = 0; i < elements.length; i++) {
            elements[i].addEventListener('mousedown', showMenu);
            elements[i].addEventListener('mouseleave', hideMenu);
        }

        function showMenu() {
            if (this.children.length > 1) {
                this.children[1].style.height = 'auto';
                this.children[1].style.opacity = '1';
                this.children[1].style.overflow = 'visible';
            }
        }

        function hideMenu() {
            if (this.children.length > 1) {
                this.children[1].style.height = '0';
                this.children[1].style.opacity = '0';
                this.children[1].style.overflow = 'hidden';
            }
        }
    }

    /* function getTranslation() {
         //todo 1 get data from form

         //todo 2 send request (http post)
     }*/
    /*
    $('#language1').value*/

    /*$('#findTranslationBtn').on('click', doAjax);*/

    /*----------------------------------------------REQUEST TO FIND WORD-------------------------------------------------*/

    $('#mainSearchForm').submit(doAjaxRequestToFindTranslation)//on('click', doAjax);
    //$('#mainSearchForm').submit(function (){alert('нажата кнопка отправки формы')})
    function doAjaxRequestToFindTranslation() {
        var language1 = $("#select1Form").val();//form.innerText;
        var language2 = $('#select2Form').val();//innerText;
        var inputedWord = $('#inputedWordInSearch').val();
        //console.log(language1);
        if (inputedWord.length === 0) {
            alert("Введите слово для поиска!")
            return false;
        } else {
            $.ajax({
                url: 'http://localhost:8080/serchRequest/getSearchResulToMainForm',
                type: 'POST',
                dataType: 'json',
                contentType: 'application/json',
                data: JSON.stringify({
                    language1: language1,
                    language2: language2,
                    wordText: inputedWord
                }),
                success: function (data) {
                    //alert(data.translationText)
                    //alert(data.translationText.length)
                    if (data.translationText.length === 0) {
                        alert('Слово не найдено!!!')
                    } else {
                        $("#translation").text(data.translationText[0]);//нужно объект ответа преобразовать из массива строк  через \n
                    }
                },
                error: {
                    alert(message) {
                        message = "Request Error!"
                    }
                }

            });
            return false;
        }
    }

    /*----------------------------------------------REQUEST TO ADD NEW WORD-------------------------------------------------*/

   /* $('#addNewWordForm').submit(doAjaxRequestToAddNewWord())

    function doAjaxRequestToAddNewWord() {
        var wordLanguageCode = $('#select1AddNewWord').val();
        var wordTranslationLanguageCode = $('#select2AddNewWord').val();
        var newWord = $("#inputedNewWordToAdded").val();
        var wordTranslation = $('#inputedTranslationForNewWord').val();

        if (newWord.length === 0) {
            alert("Введите слово для добавления!")
            return false;
        } else {
            if (wordTranslation.length === 0) {
                alert("Введите перевод!")
                return false;
            } else {

                $.ajax({
                    url: 'http://localhost:8080/addToDictionary/addNewWord',
                    type: 'POST',
                    dataType: 'json',
                    contentType: 'application/json',
                    data: JSON.stringify({
                        wordLanguageCode: wordLanguageCode,
                        wordTranslationLanguageCode: wordTranslationLanguageCode,
                        newWord: newWord,
                        wordTranslation: wordTranslation
                    }),
                    success: function (data) {

                        if (data.responseMessage.length === 0) {
                            alert('Ошибка на сервере, в ответ получен null!')
                        } else {
                            alert(data.responseMessage);
                        }
                    },
                    error: {
                        alert(message) {
                            message = "Request Error!"
                        }
                    }

                });
                return false;
            }
        }
    }*/

    /*----------------------------------------------REQUEST TO ADD NEW LANGUAGE-------------------------------------------------*/
/*
    $('#addNewLanguageInToDictionary').click(doAjaxRequestToAddNewLanguage)

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

                        $.ajax({
                            url: 'http://localhost:8080/serchRequest/getAllRowsFromLanguages',
                            type: 'GET',

                            success: function (data) {
                                if(data.languageCode.length === 0){
                                    alert("Нет списка кодов языков");
                                }else {
                                    if(data.languageName.length === 0){
                                        alert("Нет списка имён языков");
                                    }else {
                                        /!****!/


                                        function createNewRows(){
                                        let i = 0;
                                        let count1 = 1;
                                        let count2 = 2;
                                        var languageCode = data.languageCode[i];
                                        var languageName = data.languageName[i];
    /!*Попробовать создавть объекты строк с попощью jquery $(tr) *!/
                                            /!**!/
                                        markup = "<tr>" + //markup = "<tr id = "+count1+">" + Для строки нужно генерить id а всем остальным элементам в ней задать классы, чтобы потом через query брабатывать их
                                            "<td>" + languageCode + "</td>" + //"<td><p id = >" + languageCode + "</p></td>" +  id для всех элеменотв формируется из имении параметра который содержит блок и id языка - <td id = languageCodetext+idЯзыка>languageCode</td> где languageCode = eng и id = 2  у ENGLISH
                                            "<td>" + languageName + "</td>" +
                                            /!*Сделать все 4 кнопки в одной ячейке td*!/
                                            "<td>" + "<button id = " + count1 + " type=click>Редактировать</button>" + "</td>" + //(count++)
                                            "<td>" + "<button id = " + count2 + " type=click>Удалить</button>" + "</td>" +
                                            "</tr>";
                                        count1++;
                                        count2++;
                                        i++
                                        tableBody = $("table tbody");
                                        tableBody.append(markup);
                                    }
                                        data.languageCode.forEach(createNewRows())
                                    }
                                }

                            }
                            /!*{
                                if (data.langCode.length === 0) {
                                    alert('Слово не найдено!!!')
                                } else {
                                    $("#translation").text(data.translationText[0]);//нужно объект ответа преобразовать из массива строк  через \n

                                    var tr = document.createElement("tr"), td;
                                    for (let i = 0; i < 3; i++) {
                                        td = document.createElement("td");
                                        td.innerHTML = this.elements[i].value;
                                        tr.appendChild(td);
                                    }
                                    table.appendChild(tr);
                                }
                            }*!/
                        }); return false;
                    }

                });
                return false;
            }
        }
    }*/
   /* function doAjaxRequestToGetallDataAboutLanguages(){
        $.ajax({
            url: 'http://localhost:8080/serchRequestFromMainForm/addNewLanguage',
            type: 'GET'
        })
    }*/
});
