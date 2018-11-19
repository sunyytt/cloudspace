package com.example.springboot.zuul.filter;

import com.alibaba.fastjson.JSON;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.http.HttpHeaders;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/**
 * @Auther: sunyy
 * @Date: 2018/11/16 17:18
 * @Description:
 */
public class AuthFliter extends ZuulFilter {

    /**
     *  <b>Filter类型</b>
     *  <li>PRE： 这种过滤器在请求被路由之前调用。我们可利用这种过滤器实现身份验证、在集群中选择请求的微服务、记录调试信息等。
     *  <li>ROUTING：这种过滤器将请求路由到微服务。这种过滤器用于构建发送给微服务的请求，并使用Apache HttpClient或Netfilx Ribbon请求微服务。
     *  <li>POST：这种过滤器在路由到微服务以后执行。这种过滤器可用来为响应添加标准的HTTP Header、收集统计信息和指标、将响应从微服务发送给客户端等。
     * <li>ERROR：在其他阶段发生错误时执行该过滤器。
     */
    /**
     * 指定该Filter的类型
     * ERROR_TYPE = "error";
     * POST_TYPE = "post";
     * PRE_TYPE = "pre";
     * ROUTE_TYPE = "route";
     */
    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    /**
     * 指定该Filter执行的顺序（Filter从小到大执行）
     * DEBUG_FILTER_ORDER = 1;
     * FORM_BODY_WRAPPER_FILTER_ORDER = -1;
     * PRE_DECORATION_FILTER_ORDER = 5;
     * RIBBON_ROUTING_FILTER_ORDER = 10;
     * SEND_ERROR_FILTER_ORDER = 0;
     * SEND_FORWARD_FILTER_ORDER = 500;
     * SEND_RESPONSE_FILTER_ORDER = 1000;
     * SIMPLE_HOST_ROUTING_FILTER_ORDER = 100;
     * SERVLET_30_WRAPPER_FILTER_ORDER = -2;
     * SERVLET_DETECTION_FILTER_ORDER = -3;
     */
    @Override
    public int filterOrder() {
        return -1;
    }

    /**
     * 指定需要执行该Filter的规则
     * 返回true则执行run()
     * 返回false则不执行run()
     */
    @Override
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String requestUrl = request.getRequestURL().toString();
        System.out.println("requestUrl="+requestUrl);
        System.out.println("login="+requestUrl.contains("login"));
        System.out.println("register="+requestUrl.contains("register"));
        // 请求URL内不包含login或register则需要经过该过滤器，即执行run()
        return !requestUrl.contains("login") && !requestUrl.contains("register");
    }

    /**
     * 其他路径 公钥解密 校验token
     */
    @Override
    public Object run() {

        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();

//        HttpMethod.OPTIONS.name().equals(request.getMethod())
//        Object accessToken = request.getHeader("Authorization");
        final String accessToken = request.getHeader(HttpHeaders.AUTHORIZATION);
        System.out.println("zuul->AuthFliter->accessToken="+accessToken);

        if (StringUtils.isEmpty(accessToken) || !accessToken.startsWith("bearer")){
            // Missing or invalid Authorization header
            requestContext.setSendZuulResponse(false);//终止转发，返回响应报文
            requestContext.setResponseStatusCode(HttpServletResponse.SC_UNAUTHORIZED);
//            requestContext.setResponseBody("Authorization token is empty");
            Map<String,Object> responseMap=new HashMap<String,Object>();
            responseMap.put("code", HttpServletResponse.SC_UNAUTHORIZED);
            responseMap.put("msg", "Authorization token is empty");
            requestContext.setResponseBody(JSON.toJSONString(responseMap));
        }else{
            //这里可以进一步校验token的合法性、时效性，甚至对报文进行校验
            //校验是否过期
//            requestContext.addZuulRequestHeader("userName", userName);
            requestContext.setSendZuulResponse(true); //将请求往后转发
            requestContext.setResponseStatusCode(200);
        }
        return null;
    }
}
