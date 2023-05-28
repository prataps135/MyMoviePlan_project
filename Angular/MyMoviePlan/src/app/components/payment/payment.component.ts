import { Component,OnInit } from '@angular/core';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.scss']
})
export class PaymentComponent implements OnInit{
  paymentHandler: any = null;

  constructor() {}

  ngOnInit() {
    this.invokeStripe();
  }

  makePayment(amount: any) {
    const paymentHandler = (<any>window).StripeCheckout.configure({
      key: 'pk_test_51NCbiESFbCnn4TXC7PCbD9hIWWiAr4u3PL6YIxuZCd4L8b0yWCdeqFmIpdebRCHZYEMAPt2ZzuUue8fR5cruWxxR006GatyNlR',
      locale: 'auto',
      token: function (stripeToken: any) {
        console.log(stripeToken);
        alert('payment was Successful');
      },
    });
    paymentHandler.open({
      name: 'Movie Plan',
      description:
        'A one stop for movie tickets now purchase with only single click',
      amount: amount * 100,
    });
  }

  invokeStripe() {
    if (!window.document.getElementById('stripe-script')) {
      const script = window.document.createElement('script');
      script.id = 'stripe-script';
      script.type = 'text/javascript';
      script.src = 'https://checkout.stripe.com/checkout.js';
      script.onload = () => {
        this.paymentHandler = (<any>window).StripeCheckout.configure({
          key: 'pk_test_51NCbiESFbCnn4TXC7PCbD9hIWWiAr4u3PL6YIxuZCd4L8b0yWCdeqFmIpdebRCHZYEMAPt2ZzuUue8fR5cruWxxR006GatyNlR',
          locale: 'auto',
          token: function (stripeToken: any) {
            console.log(stripeToken);
            alert('Payment has been successful!');
          },
        });
      };
      window.document.body.appendChild(script);
    }
  }

}
