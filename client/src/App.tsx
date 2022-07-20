import React from 'react';
import * as S from './styles/common';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Feed from './pages/feed';
import SignIn from './pages/signIn';
import SignUp from './pages/SignUp';
import SignUp2 from './pages/SignUp2';
import MyPage from './pages/myPage';
import FeedDetail from './pages/feedDetail';

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Feed />}></Route>
        <Route path="/:id" element={<FeedDetail />}></Route>
        <Route path="/signin" element={<SignIn />}></Route>
        <Route path="/signup" element={<SignUp />}></Route>
        <Route path="/signup2" element={<SignUp2 />}></Route>
        <Route path="/my" element={<MyPage />}></Route>
      </Routes>
    </BrowserRouter>
  );
}

export default App;
