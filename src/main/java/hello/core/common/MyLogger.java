package hello.core.common;

import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.UUID;

@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MyLogger {

    private String uuid;
    @Setter
    private String requestUrl;

    public void log(String message) {
        System.out.printf("[%s][%s]-%s\n", uuid, requestUrl, message);
    }

    @PostConstruct
    public void init() {
        uuid = UUID.randomUUID().toString();
        System.out.printf("[%s]-request scope bean created:%s\n", uuid, this);
    }

    @PreDestroy
    public void close() {
        System.out.printf("[%s]-request scope bean closed:%s\n", uuid, this);
    }

}
