import './App.css';
import TitleAppBar from './TitleAppBar'
import ThreadPage from './threadPage/ThreadPage';

import {
  BrowserRouter as Router,
  Routes,
  Route,
  Link,
  Navigate,
} from "react-router-dom";



function App() {
  return (
    <>
      <TitleAppBar/>
      <Router>
        <Routes>
          <Route exact path='/home' element={<ThreadPage/>}/>
          <Route path="/*" element={<Navigate to="/home" />} />
        </Routes>
      </Router>
    </>
  );
}

export default App;
