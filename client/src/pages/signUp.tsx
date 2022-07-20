import Input from '../components/Input';
import React from 'react';
import styled from 'styled-components';
import * as S from '../styles/common';
import { useNavigate } from 'react-router-dom';

const SignUp = () => {
  const navigate = useNavigate();
  return (
    <S.Layout>
      <S.Inner>
        <Header>회원가입 1/2</Header>
        <Main>
          <Input placeholder="이메일" type="text" />
          <Input placeholder="닉네임" type="text" />
          <Input placeholder="비밀번호" type="password" />
          <Input placeholder="비밀번호 확인" type="password" />
          <Input placeholder="주소" type="text" />
          <Input placeholder="상세 주소" type="text" />
          <button onClick={() => navigate('/signup2')}>다음</button>
        </Main>
      </S.Inner>
    </S.Layout>
  );
};

export default SignUp;

const Header = styled.header`
  background-color: gray;
  color: white;
  text-align: center;
`;
const Main = styled.main`
  display: flex;
  flex-direction: column;
  margin: 0 2rem;
  & > input {
    margin: 0.5rem 0;
  }
  & > button {
    margin-top: 1rem;
  }
  margin-top: 1rem;
`;
