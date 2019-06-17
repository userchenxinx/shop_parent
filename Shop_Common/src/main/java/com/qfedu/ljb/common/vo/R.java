package com.qfedu.ljb.common.vo;

public class R {
    private int code;
    private String msg;
    private Object data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static R setOk(){
        R r = new R();
        r.setCode(1);
        r.setMsg("OK");
        r.setData(null);
        return  r;
    }
    public static R setOK(String msg,Object data){
        R r=new R();
        r.setCode(1);
        r.setMsg(msg);
        r.setData(data);
        return r;
    }
    public static R setERROR(){
        R r=new R();
        r.setCode(1000);
        r.setMsg("ERROR");
        r.setData(null);
        return r;
    }
    public static R setERROR(String msg){
        R r=new R();
        r.setCode(1000);
        r.setMsg(msg);
        r.setData(null);
        return r;
    }
}
