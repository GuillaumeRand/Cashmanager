const express = require("express");
const app = express();
const { resolve } = require ("path");

const stripe = require("stripe")('sk_test_51K6HVQLQqDobSi5Xrkevxg2V20gnNgPb2PpMabjYOcdQ3q7Hvt6V3xTLt4B2MYoache5ldPABcdDqUyt9GsxMxnj00hoF3UBDX');

app.use(express.static("."));
app.use(express.json());

const calculateOrderAmount = (items) => {
  console.log(items[0].amount)
  return items[0].amount;
};

app.post("/create-payment-intent", async (req, res) => {
  const { items } = req.body;
  const { currency } = req.body;

  // Create a PaymentIntent with the order amount and currency
  const paymentIntent = await stripe.paymentIntents.create({
    amount: calculateOrderAmount(items),
    currency: currency,
    automatic_payment_methods: {
      enabled: true,
    },
  });

  res.send({
    clientSecret: paymentIntent.client_secret,
  });
});

app.get("/greet", async (req,res) => {
    res.send('Hello, It is working!');   
});

// app.listen(4242, () => console.log("Node server listening on port 4242!"));
const PORT = process.env.PORT || 5001;
app.listen(PORT, () => console.log('Node server listening on port ${PORT}'));
