import request from '@/utils/request'

export function login(data) {
  return request({
    url: '/admin/auth/login',//logintest /admin/auth/login
    method: 'get',
    params:{userName:data.username,pass:data.password}
  })
}

export function getInfo(token) {
  return request({
    url: '/admin/auth/user/info',
    method: 'get',
    params: { token }
  })
}

export function logout() {
  return request({
    url: '/admin/auth/user/logout',
    method: 'post'
  })
}
