package hello.advanced.trace.common.service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ServiceImpl implements ServiceInterface {

    @Override
    public void save() {
        log.info("save 실행");
    }


    @Override
    public void find() {
        log.info("find 실행");
    }
}
