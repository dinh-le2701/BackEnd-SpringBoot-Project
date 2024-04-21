import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import { List } from './Todo List/List/List';
import { Task } from './Todo List/Task/Task';
import Container from "react-bootstrap/Container"

function App() {
  return (
    <div className="App">
      <Container>
        <Task/>
        <List />
      </Container>
    </div>
  );
}

export default App;
