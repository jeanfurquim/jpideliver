import { useState } from "react"

function Counter (){
    const [counter, setCounter] = useState(0);
    const handleIncrease =() =>{
        console.log('incrementar')
        setCounter(counter + 1);

    }

    const handleDecrease =() =>{
        console.log('descrementar')
        setCounter(counter - 1);

    }

    return (
        <div>
          <button onClick={handleIncrease}>Incrementar</button>
          <button onClick={handleDecrease}>Descrementar</button>
          <h1>
              Valor do Contador: {counter}</h1>
        </div>
    )
}

export default Counter;