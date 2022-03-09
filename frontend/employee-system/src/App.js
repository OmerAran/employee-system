import './App.css';
import ListEmployeeComponent from "./components/ListWorkerComponent"
import HeaderComponent from "./components/HeaderComponent"
import FooterComponent from "./components/FooterComponent"
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
function App() {
  return (
    <div>
       <Router>
         <div className="container"> 
           <HeaderComponent />
            <div className="container">
             <Routes> {/* Switch*/ }
               <Route path="/" component={ListEmployeeComponent}></Route>
               <Route path="/workers" component={ListEmployeeComponent}></Route>
              <ListEmployeeComponent />
             </Routes>
              </div>
          <FooterComponent />
           </div>
        </Router>
    </div>
    
  );
}

export default App;
