import React, { useState } from 'react';
import * as S from '../styles/common';
import styled from 'styled-components';
import { useNavigate } from 'react-router-dom';

const SignIn = () => {
  const navigate = useNavigate();
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');

  const onClickSubmit = () => {
    if (email === 'test' && password === '1234') {
      navigate('/');
      const timer = setTimeout(() => {
        alert('로그인 성공');
        clearTimeout(timer);
      }, 1000);
    }
  };
  return (
    <S.Layout>
      <S.Inner>
        <Col>
          <HeaderSample></HeaderSample>

          <Logo>로고</Logo>
          <LoginFormSection>
            <LoginFormIdBox>
              <Row>
                <LoginFormIdIcon></LoginFormIdIcon>
                <LoginFormIdInput
                  type="text"
                  placeholder="Username"
                  onChange={(e) => setEmail(e.target.value)}
                ></LoginFormIdInput>
              </Row>
            </LoginFormIdBox>
            <LoginFormPwBox>
              <Row>
                <LoginFormPwIcon></LoginFormPwIcon>
                <LoginFormPwInput
                  type="password"
                  placeholder="* * * * * * * *"
                  onChange={(e) => setPassword(e.target.value)}
                ></LoginFormPwInput>
              </Row>
            </LoginFormPwBox>

            <SubmitBtn onClick={onClickSubmit}>로그인</SubmitBtn>
            <Row>
              <ForgotIdBtn>아이디 찾기</ForgotIdBtn>
              <ForgotPwBtn>비밀번호 찾기</ForgotPwBtn>
            </Row>
          </LoginFormSection>

          <SignUpBox>
            계정이 없으신가요?
            <SignUpBtn>가입하기</SignUpBtn>
          </SignUpBox>
        </Col>
      </S.Inner>
    </S.Layout>
  );
};

export default SignIn;
const HeaderSample = styled.div`
  height: 60px;
  background: gray;
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
`;

const Col = styled.div`
  display: flex;
  flex-direction: column;
  padding: 10px;
  height: 100vh;
  box-sizing: border-box;
  justify-content: space-between;
  position: relative;
  overflow: hidden;
`;

const Row = styled.div`
  display: flex;
  padding: 10px;
  align-items: center;
  justify-content: space-around;
`;

const Logo = styled.div`
  margin-top: 60px;
  height: 300px;
  min-height: 200px;
  border: 1px solid gray;
`;

const LoginFormSection = styled.section`
  border-bottom: 1px solid gray;
`;

const LoginFormIdBox = styled.div`
  margin: 10px;
  font-weight: bold;
  font-size: 1.8rem;
  border: 1px solid rgb(128, 128, 128, 0.4);
`;

const LoginFormIdIcon = styled.div`
  width: 20px;
  height: 20px;
  border: 1px solid gray;
`;

const LoginFormIdInput = styled.input`
  width: 100%;
  height: 100%;
  outline: none;
  border: none;
  background: whitesmoke;
  padding-left: 10px;
`;

const LoginFormPwBox = styled.div`
  margin: 10px;
  font-weight: bold;
  font-size: 1.8rem;
  border: 1px solid rgb(128, 128, 128, 0.4);
`;

const LoginFormPwIcon = styled.div`
  width: 20px;
  height: 20px;
  border: 1px solid gray;
`;

const LoginFormPwInput = styled.input`
  width: 100%;
  height: 100%;

  outline: none;
  border: none;
  background: whitesmoke;
  padding-left: 10px;
`;

const SubmitBtn = styled.div`
  margin: 10px;
  height: 50px;
  box-sizing: border-box;
  border: 1px solid rgb(128, 128, 128, 0.4);
  color: black;
  font-weight: bold;
  display: flex;
  justify-content: center;
  align-items: center;
  font-size: 2rem;

  &:hover {
    background: rgb(128, 128, 128, 0.4);
    cursor: pointer;
  }
`;

const ForgotIdBtn = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
  font-weight: bold;
  font-size: 1.4rem;
  color: gray;
  border-bottom: 1px solid whitesmoke;
  &:hover {
    cursor: pointer;
    border-bottom: 1px solid blue;
    color: blue;
  }
`;

const ForgotPwBtn = styled(ForgotIdBtn)``;

const SignUpBox = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
  padding: 10px;
  color: gray;
  margin-top: 10px;
  border: 1px solid rgb(128, 128, 128, 0.4);
`;
const SignUpBtn = styled(ForgotIdBtn)`
  margin-left: 10px;
  color: black;
`;
