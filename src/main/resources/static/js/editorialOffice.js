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

    $('#mainSearchForm').submit(doAjax)//on('click', doAjax);
    //$('#mainSearchForm').submit(function (){alert('нажата кнопка отправки формы')})
    function doAjax() {
        var language1 = $("#select1Form").val();//form.innerText;
        var language2 = $('#select2Form').val();//innerText;
        var inputedWord = $('#inputedWordInSearch').val();
        //console.log(language1);
        if (inputedWord.length === 0) {
            alert("Введите слово для поиска!")
            return false;
        } else {
            $.ajax({
                url: 'http://localhost:8080/serchRequestFromMainForm/getSearchResulToMainForm',
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


});
