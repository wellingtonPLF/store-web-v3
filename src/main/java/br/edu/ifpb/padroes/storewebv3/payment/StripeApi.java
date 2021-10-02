package br.edu.ifpb.padroes.storewebv3.payment;

import br.edu.ifpb.padroes.storewebv3.config.StoreConfigurationProperties;
import br.edu.ifpb.padroes.storewebv3.domain.Order;
import br.edu.ifpb.padroes.storewebv3.domain.Product;
import br.edu.ifpb.padroes.storewebv3.mediator.Mediator;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.model.Sku;
import com.stripe.param.PaymentIntentCreateParams;
import com.stripe.param.SkuCreateParams;
import org.springframework.stereotype.Component;

@Component
public class StripeApi implements Mediator{

    private final StoreConfigurationProperties storeConfigurationProperties;

    public StripeApi(StoreConfigurationProperties storeConfigurationProperties) {
        this.storeConfigurationProperties = storeConfigurationProperties;
    }

    public PaymentIntent createOrder(Order order) {
        try {
            Stripe.apiKey = storeConfigurationProperties.getStripeKey();
            PaymentIntentCreateParams params = PaymentIntentCreateParams.builder()
                    .setAmount(1000L)
                    .setCurrency("usd")
                    .addPaymentMethodType("card")
                    .setReceiptEmail("jenny.rosen@example.com")
                    .build();
            return PaymentIntent.create(params);
        } catch (StripeException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Sku createSKU(Order order, Product product) {
        SkuCreateParams skuCreateParams = SkuCreateParams.builder().setCurrency("BRL").setPrice(product.getPrice()).setProduct(product.getTitle()).build();
        try {
            return Sku.create(skuCreateParams);
        } catch (StripeException e) {
            e.printStackTrace();
        }
        return null;
    }


}
