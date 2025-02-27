import { useState } from 'react';
import './App.css'
import { createContext, useContext } from 'react';

let CartContext = createContext();

function CartProvider ( {children} ) { //데이터 값 / 동작값 저장
  const [cart, setCart] = useState([]);

  function handleCart(product, action) {
    if( action === "add" ) {
      setCart( [...cart, product] );

    }else if(action === "delete") {
      setCart(  cart.filter(  (c) => c.id !== product.id   )   )
    }

  }

  return(
    <></>
  );
}

function ProductList() {

  let {cart, handleCart} = useContext(CartContext);

  let products = [
    { id:1, itemName: "컴퓨터", price: 100000 },
    { id:2, itemName: "모니터", price: 200000 },
    { id:3, itemName: "마우스", price: 300000 }
  ];

  return(
    <>
      <h1>양정인력개발센터 쇼핑몰</h1>
      <h2>000 쇼핑몰 상품 목록</h2>
      <ol>
        {
          products.map(   (product, idx) => (
            <li key={idx}>{product.itemName} - {product.price}원 
            <button onClick={ () => handleCart(product, "add")  }>카트추가</button></li>
          )   )
        }
      </ol>

      <hr />

      <h2>내 카트에 담긴 상품</h2>
      <p>카트에 담긴 상품이 없습니다.</p>
      <ul>
        <li>
          {/* <button onClick={ () => handleCart(product, "delete")}>담긴상품삭제</button> */}
        </li>
      </ul>

    </>
  );
}


function App() {

  return(
    <>
      <ProductList />
    </>
  );
}

export default App

