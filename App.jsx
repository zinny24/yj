import { useState } from 'react';
import { createContext, useContext } from 'react';

let ToDoContext = createContext();

let ToDoProvider = ( {children} ) => {

  const [todos, setTodos] = useState([]);


  function toggleTodo(idx) {
    let changeToDo = todos.map(   (t, index) => index === idx ? {...t, completed: !t.completed} : t );
      setTodos(changeToDo);
    }
  
    return(
    <ToDoContext.Provider value= {{todos, addTodo, toggleTodo}}>
      {children}
    </ToDoContext.Provider>
  );
}

let ToDoList = () => {
  let {todos, toggleTodo} = useContext(ToDoContext);
  return(
    <ul>
      {
        todos.map( (todo, idx) => (<li style={{cursor: "pointer"}} key={idx} onClick={ () => toggleTodo(idx)}>{todo.content} 
        - {todo.completed ? "완료" : "진행중"}</li>) )
      }
    </ul>
  );
}

let ToDoAdd = () => {

  let {addTodo} = useContext(ToDoContext);

  const [input, setInput] = useState("");

  function handleSubmit(e) {
    e.preventDefault();

    if( input.trim() ) {
        addTodo( {content: input, completed: false} );
        setInput("");
    }
  }

  return(
    <>
      <form onSubmit={handleSubmit}>
        <input type="text" 
        onChange={ (e) => setInput(e.target.value)} 
        value={input}        
        />
        <button type="submit">ADD</button>
      </form>
    </>
  );
}

function App() {
  return(
    <ToDoProvider>
      <ToDoAdd />
      <ToDoList />
    </ToDoProvider>
  )
}

export default App;