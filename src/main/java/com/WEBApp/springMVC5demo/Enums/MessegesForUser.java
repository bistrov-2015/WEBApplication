package com.WEBApp.springMVC5demo.Enums;


public enum MessegesForUser {
    NEW_LANGUAGE_ADDED_SUCCESFULLY("Новый язык успешно дбавлен!"),
    NEW_LANGUAGE_ADDED_FAILURE("Неудача при добавлении, скорее всего уже существует язык с таким именем или кодом!"),
    DELETE_SUCCES("Успешно удалено"),
    DELETE_FAIL("Ошибка при удалении"),
    UPDATE_DONE("Данные обновлены"),
    ERROR("Ошибка! ");
    final String messege;

    MessegesForUser(String messege){
        this.messege = messege;
    }

    public String getMessege() {
        return messege;
    }
}