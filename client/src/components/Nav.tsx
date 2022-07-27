import React from 'react';
import styled from 'styled-components';
import js from '../imgs/js.png';

export default function Nav() {
  return (
    <Layout>
      <NavBox>
      <div>
        <img src={js} alt="hi" />
        <span>여행자1</span>
      </div>
      <div>
        <button>메뉴</button>
      </div>

      </NavBox>
      
      
    </Layout>
  );
}

const Layout = styled.div`
  position:fixed;
  width: 100%;
  height:auto;
  display: flex;
  align-items: center;
  justify-content: center;

  & > div:first-child {
    display: flex;
    margin-left: 1.5rem;
    align-items: center;
    img {
      width: 3rem;
      height: 3rem;
      border-radius: 1.5rem;
    }
    span {
      margin-left: 1rem;
    }
  }
  & > div:last-child {
    margin-right: 1.5rem;
    display: flex;
    align-items: center;
    button {
      width: 5rem;
      height: 2rem;
    }
  }
`;


const NavBox = styled.div`
  display:flex;
  min-width:375px;
  width:auto;
  height:60px;
  justify-content: space-between;
  background-color: gray;
`
