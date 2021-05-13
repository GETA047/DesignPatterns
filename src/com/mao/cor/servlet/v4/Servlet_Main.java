package com.mao.cor.servlet.v4;

import java.util.ArrayList;
import java.util.List;

public class Servlet_Main {
    public static void main(String[] args) {
        Request request = new Request();
        request.str = "大家好:)，<script>，欢迎访问 mao.com，大家都是996";
        Response response = new Response();
        response.str = "response";

        FilterChain filterChain = new FilterChain();
        filterChain.add(new HTMLFilter()).add(new SensetiveFilter());
        filterChain.doFilter(request, response);
        System.out.println(request.str);
        System.out.println(response.str);
        
    }
}

class Request {
    String str;
}

class Response {
    String str;
}

interface Filter {
    void doFilter(Request request, Response response, FilterChain filterChain);
}

class HTMLFilter implements Filter {

    @Override
    public void doFilter(Request request, Response response, FilterChain filterChain) {
        request.str = request.str.replaceAll("<", "[").replaceAll(">", "]") + "HTMLFilter()";
        filterChain.doFilter(request, response);
        response.str += "--HTMLFilter()";
    }
}

class SensetiveFilter implements Filter {

    @Override
    public void doFilter(Request request, Response response, FilterChain filterChain) {
        request.str = request.str.replaceAll("996", "955") + "SensetiveFilter()";
        filterChain.doFilter(request, response);
        response.str += "--SensetiveFilter()";
    }
}

class FilterChain {
    List<Filter> filters = new ArrayList<>();
    int index = 0;

    public FilterChain add(Filter filter) {
        filters.add(filter);
        return this;
    }

    public void doFilter(Request request, Response response) {
        if (index == filters.size()) {
            return;
        }
        Filter filter = filters.get(index);
        index++;

        filter.doFilter(request, response, this);
    }

}




