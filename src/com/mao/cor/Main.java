package com.mao.cor;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Msg msg = new Msg();
        msg.setMsg("大家好:)，<script>，欢迎访问 mao.com，大家都是996");

        FilterChain fc = new FilterChain();
        fc.add(new HTMLFilter()).add(new SensetiveFilter());

        FilterChain fc2 = new FilterChain();
        fc2.add(new FaceFilter()).add(new URLFilter());

        fc.add(fc2);
        fc.doFilter(msg);
        System.out.println(msg);
    }
}

class Msg {
    String name;
    String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Msg{" +
                "msg='" + msg + '\'' +
                '}';
    }
}

interface Filter {
    boolean doFilter(Msg msg);
}

class HTMLFilter implements Filter {

    @Override
    public boolean doFilter(Msg msg) {
        String str = msg.getMsg();
        str = str.replace("<", "[");
        str = str.replace(">", "]");
        msg.setMsg(str);
        return true;
    }
}

class SensetiveFilter implements Filter {

    @Override
    public boolean doFilter(Msg msg) {
        String str = msg.getMsg();
        str = str.replaceAll("996", "955");
        msg.setMsg(str);
        return false;
    }
}

class FaceFilter implements Filter {

    @Override
    public boolean doFilter(Msg msg) {
        String str = msg.getMsg();
        str = str.replace(":)", "^3^");
        msg.setMsg(str);
        return true;
    }
}

class URLFilter implements Filter {

    @Override
    public boolean doFilter(Msg msg) {
        String str = msg.getMsg();
        str = str.replace("mao.com", "http://www.mao.com");
        msg.setMsg(str);
        return true;
    }
}

class FilterChain implements Filter {

    private List<Filter> filters = new ArrayList<>();

    public FilterChain add(Filter filter) {
        filters.add(filter);
        return this;
    }

    @Override
    public boolean doFilter(Msg msg) {
        for (Filter filter : filters) {
            if (!filter.doFilter(msg)) {
                return false;
            }
        }
        return true;
    }
}