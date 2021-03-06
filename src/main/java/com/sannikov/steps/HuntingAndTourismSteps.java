package com.sannikov.steps;

import com.sannikov.objects.pages.HuntingAndTourismPage;
import org.springframework.stereotype.Component;

@Component
public class HuntingAndTourismSteps extends BaseSteps {

    private static final ThreadLocal<HuntingAndTourismPage> HUNTING_AND_TOURISM_PAGE_THREAD_LOCAL = new ThreadLocal<>();

    private HuntingAndTourismPage getHuntingAndTourismPage() {
        return HUNTING_AND_TOURISM_PAGE_THREAD_LOCAL.get();
    }

    public void setHuntingAndTourismPage(HuntingAndTourismPage huntingAndTourismPage) {
        HUNTING_AND_TOURISM_PAGE_THREAD_LOCAL.set(huntingAndTourismPage);
    }
}
