import React from 'react';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Feed from 'pages/Feed';
import SignIn from 'pages/SignIn';
import SignUp from 'pages/SignUp';
import SignUp2 from 'pages/SignUp2';
import MyPage from 'pages/MyPage';
import FeedDetail from 'pages/FeedDetail';
import Nav from 'components/Nav';

export default function App() {
  return (
    <BrowserRouter>
      <Nav />
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
