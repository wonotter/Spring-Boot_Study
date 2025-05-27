package hello.advanced.trace.threadlocal.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FieldService {

    private String namedStore;

    public String logic(String name) {
        log.info("저장 name={} -> nameStore={}", name, namedStore);
        namedStore = name;
        sleep(1000);
        log.info("조회 nameStore={}", namedStore);
        return namedStore;
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
