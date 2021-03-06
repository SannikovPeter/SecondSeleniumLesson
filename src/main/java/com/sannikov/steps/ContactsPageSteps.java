package com.sannikov.steps;

import com.sannikov.objects.pages.ContactsPage;
import org.springframework.stereotype.Component;

@Component
public class ContactsPageSteps extends BaseSteps {
    private static final ThreadLocal<ContactsPage> CONTACTS_PAGE_THREAD_LOCAL = new ThreadLocal<>();

    private ContactsPage getContactsPage() {
        return CONTACTS_PAGE_THREAD_LOCAL.get();
    }

    public void setContactsPage(ContactsPage contactsPage) {
        CONTACTS_PAGE_THREAD_LOCAL.set(contactsPage);
    }

}
