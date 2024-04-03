import Request from '../request';
import { userStore } from '../../stores/user'

const systemBaseUrl='/system/'

export const systemRequest =(data, success, fail) => {
  const $store = userStore()
  Request.requestJson
}
