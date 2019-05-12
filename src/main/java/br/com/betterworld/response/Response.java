package br.com.betterworld.response;

import java.util.ArrayList;
import java.util.List;

public class Response<T> {

    private T data;

    private List<String> erros;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public List<String> getErros() {
        if(this.erros == null){
            this.erros = new ArrayList<String>();
        }
        return erros;
    }

    public void setErros(List<String> erros) {
        this.erros = erros;
    }
}
