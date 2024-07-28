package spring.login.web.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

// interceptor는 지역변수로 쓰면 안됨 호출 시점이 각각 분리되어있어서
// 같이 쓰려면 어딘가에 담아두어야함 ex) request
@Slf4j
public class LogInterceptor implements HandlerInterceptor {

    public static final String LOG_ID = "logId";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        String uuid = UUID.randomUUID().toString();

        request.setAttribute(LOG_ID, uuid);

        //@RequestMapping : HandlerMethod
        // 정적 리소스 :ResourceHttpRequestHandler
        if (handler instanceof HandlerMethod) {
            HandlerMethod hm = (HandlerMethod) handler;
        }

        log.info("REUEST [{]][{}][{}]", uuid, requestURI, handler);
        return true;
    }

    //Controller에서 에러발생시 호출안됨
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("postHandle [{}]", modelAndView);

    }

    // 언제든 에러 호출 가능
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        String requestURI = request.getRequestURI();
        Object logId = request.getAttribute(LOG_ID);
        log.info("RESPONSE [{}][{}][{}]", logId
                , requestURI, ex);

        if (ex!=null) {
            log.error("afterCompletion error! {}", ex);
        }
    }
}
