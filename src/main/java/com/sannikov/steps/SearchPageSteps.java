package com.sannikov.steps;

import com.sannikov.core.AppContext;
import com.sannikov.objects.AbstractBase;
import com.sannikov.objects.pages.CartPage;
import com.sannikov.objects.pages.CatalogPage;
import com.sannikov.objects.pages.SearchPage;
import org.springframework.stereotype.Component;

@Component
public class SearchPageSteps extends BaseSteps {

    private static final ThreadLocal<SearchPage> SEARCH_PAGE_THREAD_LOCAL = new ThreadLocal<>();

    private SearchPage getSearchPage() {
        return SEARCH_PAGE_THREAD_LOCAL.get();
    }

    public void setSearchPage(SearchPage searchPage) {
        SEARCH_PAGE_THREAD_LOCAL.set(searchPage);
    }

    public ItemSteps getItem(int indexOfItem) {
        ItemSteps itemSteps = AppContext.getBean(ItemSteps.class);
        itemSteps.setItem(getSearchPage().getItemsList().get(indexOfItem));
        return itemSteps;
    }

    public CatalogPageSteps addItemToCartAndContinueShopping(int indexOfItem) {
        addItemToCart(indexOfItem);
        CatalogPageSteps catalogPageSteps = AppContext.getBean(CatalogPageSteps.class);
        catalogPageSteps.setCatalogPage(AbstractBase.getPage(CatalogPage.class));
        saveClick(getSearchPage().getPopUp().getContinueButton());
        return catalogPageSteps;
    }

    public CartPageSteps addItemToCartAndGoToCart(int indexOfItem) {
        addItemToCart(indexOfItem);
        CartPageSteps cartPageSteps = AppContext.getBean(CartPageSteps.class);
        cartPageSteps.setCartPage(AbstractBase.getPage(CartPage.class));
        saveClick(getSearchPage().getHeader().getPopUpShowCartButton());
        return cartPageSteps;
    }

    private void addItemToCart(int indexOfItem) {
        ItemSteps itemSteps = AppContext.getBean(ItemSteps.class);
        itemSteps.setItem(getSearchPage().getItemsList().get(indexOfItem));
        itemSteps.addItemToCart();
    }

}
