import React, { useState } from 'react';
import styled from 'styled-components';
import * as S from '../styles/common';
import { useNavigate } from 'react-router-dom';
import { ImgArr } from 'assets';

const Feed = () => {
  const navigate = useNavigate();
  const onClickTargetItem = (idx: number) => {
    console.log(idx, 'target Item');
    // navigate(`/${idx}`,{ replace: true, state: {targetId:idx} });
    navigate(`/${idx}`);
  };

  return (
    <S.Layout>
      <S.Inner>
        <Col>
          {/* <HeaderSample></HeaderSample> */}
          <FeedList>
            {ImgArr.map((_, idx: number) => {
              return (
                <FeedItem onClick={() => onClickTargetItem(idx)} key={idx}>
                  <FeedItemTopBox>
                    <div>지역</div>
                    <FeedItemImage image={ImgArr[idx]} />
                  </FeedItemTopBox>
                  <div>{idx} 번째 글</div>
                  <FeedItemBottomBox>
                    <Row>
                      <div>서울 from 0.4km</div>
                      <div>좋아요:1 댓글:1</div>
                    </Row>
                    <CommentList>
                      <CommentItem>댓글1</CommentItem>
                      <CommentItem>댓글2</CommentItem>
                      <CommentItem>댓글3</CommentItem>
                      <CommentItem>댓글4</CommentItem>
                      <MoreCommentBtn>댓글 모두보기</MoreCommentBtn>
                    </CommentList>
                  </FeedItemBottomBox>
                </FeedItem>
              );
            })}
          </FeedList>
        </Col>
      </S.Inner>
    </S.Layout>
  );
};

export default Feed;

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
  justify-content: space-between;
`;

const FeedList = styled.ul`
  margin-top: 60px;
  border: 1px solid gray;
  height: 100%;
  overflow: scroll;
`;

const FeedItem = styled.li`
  display: flex;
  flex-direction: column;
  margin: 10px;
  margin-bottom: 10px;
  height: auto;
  min-height: 100px;
  border: 1px solid gray;
  &:hover {
    cursor: pointer;
    background: whitesmoke;
  }
`;

const FeedItemTopBox = styled.div`
  height: auto;
`;

const FeedItemImage = styled.div<{ image: any }>`
  display: flex;
  justify-content: center;
  align-items: center;
  height: 200px;
  width: auto;
  /* background: rgb(128, 128, 128, 0.4); */
  background-color: rgb(0, 0, 0, 0.9);
  background-image: url(${(props) => props.image});

  background-repeat: no-repeat;
  background-position: center;
  /* background-size:contain; */
  background-size: cover;
`;

const FeedItemBottomBox = styled.div`
  height: auto;
  display: flex;
  flex-direction: column;
  margin: 10px;
`;

const CommentList = styled.ul`
  list-style: none;
  margin-top: 10px;
  border: 1px solid gray;
`;

const CommentItem = styled.li`
  margin-bottom: 4px;
`;

const MoreCommentBtn = styled.div`
  margin-top: 10px;
  font-size: 1.6rem;
  color: gray;
`;
