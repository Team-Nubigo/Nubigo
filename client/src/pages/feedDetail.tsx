import React, { useEffect, useRef, useState } from 'react';
import * as S from '../styles/common';
import styled from 'styled-components';

const FeedDetail = () => {
  //@typescript-eslint/no-explicit-any
  const TextareaRef = useRef<any>(null);
  const [prevHeight, setPrevHeight] = useState(10);
  const [textAreaValue, setTextAreaValue] = useState('');
  const [listMargin, setListMargin] = useState(74);

  useEffect(() => {
    if (TextareaRef) {
      setPrevHeight(TextareaRef.current.scrollHeight);
    }
  });
  const onChangeTextarea = (e: React.ChangeEvent<HTMLTextAreaElement>) => {
    // console.log(TextareaRef.current.scrollHeight)
    const height = TextareaRef.current.scrollHeight;
    // console.log(height)
    setTextAreaValue(e.target.value);
  };

  useEffect(() => {
    if (TextareaRef) {
      TextareaRef.current.style.height = '0px';
      const scrollHeight = TextareaRef.current.scrollHeight;
      TextareaRef.current.style.height = scrollHeight + 'px';
      setListMargin(scrollHeight + 60);
    }
  }, [textAreaValue]);

  return (
    <S.Layout>
      <S.Inner>
        <Col>
          <CommentList margin={listMargin}>
            <CommentItem>
              <ProfileImage>이미지</ProfileImage>
              <ContentBox>
                <NickName>hong gil dong</NickName>
                <span>
                  is simply dummy text of the printing and typesetting industry.
                  Lorem Ipsum has been the industry's standard dummy text ever
                  since the 1500s, when an unknown printer took a galley of type
                  and scrambled it to make a type specimen book. It has survived
                  not only five centuries, but also the leap into electronic
                  typesetting, remaining essentially unchanged. It was
                  popularised in the 1960s with the release of Letraset sheets
                  containing Lorem Ipsum passages, and more recently with
                  desktop publishing software like Aldus PageMaker including
                  versions of Lorem Ipsum.
                </span>
              </ContentBox>
            </CommentItem>
            <CommentItem>
              <ProfileImage>이미지</ProfileImage>
              <ContentBox>
                <NickName>hong gil dong</NickName>
                <span>hong gil dong</span>
              </ContentBox>
            </CommentItem>

            <CommentItem>
              <ProfileImage>이미지</ProfileImage>
              <ContentBox>
                <NickName>hong gil dong</NickName>
                <span>hong gil dong</span>
              </ContentBox>
            </CommentItem>

            <CommentItem>
              <ProfileImage>이미지</ProfileImage>
              <ContentBox>
                <NickName>hong gil dong</NickName>
                <span>hong gil dong</span>
              </ContentBox>
            </CommentItem>

            <CommentItem>
              <ProfileImage>이미지</ProfileImage>
              <ContentBox>
                <NickName>hong gil dong</NickName>
                <span>hong gil dong</span>
              </ContentBox>
            </CommentItem>

            <CommentItem>
              <ProfileImage>이미지</ProfileImage>
              <ContentBox>
                <NickName>hong gil dong</NickName>
                <span>hong gil dong</span>
              </ContentBox>
            </CommentItem>

            <CommentItem>
              <ProfileImage>이미지</ProfileImage>
              <ContentBox>
                <NickName>hong gil dong</NickName>
                <span>hong gil dong</span>
              </ContentBox>
            </CommentItem>

            <CommentItem>
              <ProfileImage>이미지</ProfileImage>
              <ContentBox>
                <NickName>hong gil dong</NickName>
                <span>hong gil dong</span>
              </ContentBox>
            </CommentItem>

            <CommentItem>
              <ProfileImage>이미지</ProfileImage>
              <ContentBox>
                <NickName>hong gil dong</NickName>
                <span>hong gil dong</span>
              </ContentBox>
            </CommentItem>
          </CommentList>
        </Col>
        <FooterBox>
          <IconBox>이모티콘</IconBox>
          <CommentInputBox>
            <CommentInput
              ref={TextareaRef}
              onChange={onChangeTextarea}
            ></CommentInput>
            <Submit>게시</Submit>
          </CommentInputBox>
        </FooterBox>
      </S.Inner>
    </S.Layout>
  );
};

export default FeedDetail;

const CommentList = styled.ul<{ margin: number }>`
  /* border: 1px solid gray; */
  height: 100%;
  overflow: scroll;
  /* margin: 10px; */
  padding: 0;
  margin: 0;
  /* margin:10px; */
  margin-top: 60px;
  margin-bottom: ${(props) =>
    props.margin <= 160 ? props.margin + 'px' : '160px'};
  box-sizing: border-box;
  /* background:white; */
`;

const CommentItem = styled.li`
  display: flex;
  width: auto;
  padding: 0;
  margin: 10px;
  height: auto;
  min-height: 60px;
  padding: 10px;
  box-sizing: border-box;
  &:nth-child(1) {
    border-bottom: 1px solid rgb(128, 128, 128, 0.4);
  }
`;

const Col = styled.div`
  display: flex;
  flex-direction: column;
  /* padding: 10px; */
  height: 100%;
  /* box-sizing: border-box; */
  justify-content: space-between;
`;

const ProfileImage = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
  border-radius: 50%;
  width: 50px;
  min-width: 50px;
  height: 50px;
  border: 1px solid gray;
`;

const NickName = styled.span`
  font-weight: bold;
  margin-right: 10px;
`;

const ContentBox = styled.div`
  width: 100%;
  padding-top: 10px;
  box-sizing: border-box;
  height: auto;
  margin-left: 20px;
`;

const FooterBox = styled.div`
  position: fixed;
  bottom: 0;
  left: 0;
  display: flex;
  flex-direction: column;
  /* justify-content: center; */
  align-items: center;
  justify-content: space-between;
  height: auto;
  min-height: 74px;
  max-height: 200px;
  width: 100%;
`;

const IconBox = styled.div`
  height: 40px;
  min-height: 40px;
  width: 375px;
  background: white;
  border-top: 1px solid rgb(128, 128, 128, 0.4);
`;
const CommentInputBox = styled.div`
  display: flex;
  position: relative;
  width: 375px;
  height: auto;
  background: white;

  /* max-height:200px; */

  border-top: 1px solid rgb(128, 128, 128, 0.4);
`;

const CommentInput = styled.textarea`
  width: 100%;
  height: 20px;
  min-height: 10px;
  max-height: 100px;
  line-height: 12px;

  outline: none;
  border: none;
  padding-left: 10px;
  margin-top: 10px;
  margin-bottom: 10px;
  box-sizing: border-box;
  padding-right: 100px;
  /* padding-bottom:10px; */
`;

const Submit = styled.button`
  position: absolute;
  right: 0;
  width: 50px;
  height: 100%;
  border: none;
  color: blue;
  font-weight: bold;
`;
