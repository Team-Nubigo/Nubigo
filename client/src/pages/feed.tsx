import Nav from '../components/Nav';
import React from 'react';
import styled from 'styled-components';
import * as S from '../styles/common';

const Feed = () => {
  return (
    <S.Layout>
      <S.Inner>
        <Nav />
        Feed
      </S.Inner>
    </S.Layout>
  );
};

export default Feed;
