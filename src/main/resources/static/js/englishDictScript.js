function addToEnDictionary(){
var servResponse = document.querySelector('#addFormEngl');
document.forms.addToEnDictForm.onsubmit = function (e) {
    e.preventDefault();
    var userInputKey = document.forms.addToEnDictForm.key.value;
    var userInputValue = document.forms.addToEnDictForm.value.value;
    var xhr = new XMLHttpRequest();
    xhr.open('POST', '/englishDictionary.html')
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.onreadystatechange = function (){
        if(xhr.readyState === 4 & xhr.status === 200){
            servResponse.textContent = xhr.responseText;
        }
    }
    xhr.send(userInputKey+userInputValue);
}
}