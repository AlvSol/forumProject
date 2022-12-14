import './App.css';
import TitleAppBar from './TitleAppBar'
import ThreadPage from './threadPage/ThreadPage';
import PostsPage from './postsPage/PostsPage';

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
          <Route exact path='/thread/:id' element={<PostsPage/>}/>
          <Route path="/*" element={<Navigate to="/home" />} />
        </Routes>
      </Router>
    </>
  );
}

export default App;
