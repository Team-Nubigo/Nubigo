export interface IBoard {
  board_number?: number;
  board_writer?: string;
  board_title?: string;
  board_at?: string;
  board_photo?: string;
  board_good?: number;
  board_tourlist?: string;
}

export interface ILogin {
  user_id: string;
  User_password: string;
}

export interface ISignup {
  User_id?: string;
  User_password?: string;
  User_name?: string;
  User_address?: string;
  User_address_detail?: string;
  User_tourlist?: string;
}

export interface IGetProfile {
  number?: number;
  user_id?: string;
  user_password?: string;
  user_name?: string;
  user_address?: string;
  user_address_detail?: string;
  user_tourlist?: string;
  user_at?: string;
}

export interface IPutProfile {
  number?: number;
  User_password?: string;
  User_name?: string;
  User_address?: string;
  User_address_detail?: string;
  User_tourlist?: string;
}

export interface IGetBoardDetail {
  board_number?: number;
  board_writer?: string;
  board_title?: string;
  board_content?: string;
  board_at?: string;
  board_count?: number;
  board_photo?: string;
  board_good?: number;
  board_tourlist?: string;
}

export interface IGetComment {
  number?: number;
  comment_number?: number;
  comment_writer?: string;
  comment_content?: string;
  comment_at?: string;
  comment_good?: number;
}

export interface IPutBoard {
  Board_number?: number;
  Board_title?: string;
  Board_content?: string;
  Board_photo?: string;
}
