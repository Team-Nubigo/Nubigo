import * as I from 'types/index';
import axios from 'axios';

export const apiClient = axios.create({ baseURL: 'http://localhost:8080' });

// Board API
export async function getBoardAll() {
  try {
    const res = await apiClient.get(`/tourlist`);
    return res.data;
  } catch (err) {
    return err;
  }
}
export async function getBoardDetail(id: string) {
  try {
    const res = await apiClient.get(`/tourlist/${id}`);
    return res.data;
  } catch (err) {
    return err;
  }
}
export async function putBoardDetail(id: string, data: I.IPutBoard) {
  try {
    return await apiClient.put(`/tourlist/${id}`, data);
  } catch (err) {
    return err;
  }
}
export async function removeBoard(id: string) {
  try {
    return await apiClient.delete(`/tourlist/${id}`);
  } catch (err) {
    return err;
  }
}
// ============================================================
// UserAPI
export async function login(param: I.ILogin) {
  try {
    return await apiClient.post(`/login`, param);
  } catch (err) {
    return err;
  }
}
export async function logout() {
  try {
    return await apiClient.post(`/logout`);
  } catch (err) {
    return err;
  }
}
export async function signUp(param: I.ISignup) {
  try {
    return await apiClient.post(`/signup`, param);
  } catch (err) {
    return err;
  }
}
export async function getProfile(id: string) {
  try {
    const res = await apiClient.get(`/profile/${id}`);
    return res.data;
  } catch (err) {
    return err;
  }
}
export async function putProfile(id: string, data: I.IPutProfile) {
  try {
    return await apiClient.put(`/profile/${id}`, data);
  } catch (err) {
    return err;
  }
}
export async function removeUser(id: string) {
  try {
    return await apiClient.delete(`/profile/${id}`);
  } catch (err) {
    return err;
  }
}
// ============================================================
// CommentAPI
export async function getComment(id: string) {
  try {
    const res = await apiClient.get(`/tourlist/${id}/comment`);
    return res.data;
  } catch (err) {
    return err;
  }
}
export async function putComment(id: string, data: I.IGetComment) {
  try {
    return await apiClient.put(
      `/tourlist/${id}/${String(data.comment_number)}`,
      data
    );
  } catch (err) {
    return err;
  }
}
export async function removeComment(id: string, data: string) {
  try {
    return await apiClient.delete(`/tourlist/${id}/${data}`);
  } catch (err) {
    return err;
  }
}
