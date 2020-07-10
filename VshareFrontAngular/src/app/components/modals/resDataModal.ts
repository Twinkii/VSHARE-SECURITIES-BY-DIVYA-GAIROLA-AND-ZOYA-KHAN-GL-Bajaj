
export class ResDataModal{
 
  ticker: string;
  name: string;
  price: number;

  constructor(name,price,ticker){
    this.ticker=ticker;
    this.name=name;
    this.price=price;

  }
}