import React from 'react';
import { useNavigate } from 'react-router-dom';
import styled from 'styled-components';
import * as S from '../styles/common';

export default function SignUp2() {
  const navigate = useNavigate();
  return (
    <S.Layout>
      <S.Inner>
        <Header>회원가입 1/2</Header>
        <Main>
          <span>관심있는 여행지를 골라주세요.</span>
          <FavSelec>
            <button>서울</button>
            <button>경기</button>
            <button>강원</button>
            <button>충청</button>
            <button>전라</button>
            <button>경상</button>
            <button>제주</button>
            <button>인천</button>
            <button>부산</button>
          </FavSelec>
          <button onClick={() => navigate('/')}>회원가입 완료</button>
        </Main>
      </S.Inner>
    </S.Layout>
  );
}

const Header = styled.header`
  background-color: gray;
  color: white;
  text-align: center;
`;
const Main = styled.main`
  display: flex;
  flex-direction: column;
  margin: 0 2rem;
  & > span {
    margin: 2rem 0;
  }
  & > button:last-child {
    margin-top: 2rem;
  }
`;
const FavSelec = styled.div`
  display: flex;
  justify-content: space-between;
  flex-wrap: wrap;
  & > button {
    width: 10rem;
    height: 10rem;
    margin-bottom: 1rem;
    border-radius: 5rem;
  }
`;
