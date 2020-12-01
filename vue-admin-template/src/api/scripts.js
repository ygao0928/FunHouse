import request from '@/utils/request'

export function getList(data) {
  return request({
    url: '/admin/scripts/getList',//logintest /admin/auth/login
    method: 'post'
  })
}
export function addScriptFrom(data) {
  return request({
    url: '/admin/scripts/addDrama',//logintest /admin/auth/login
    method: 'post',
    data
  })
}


export function getScriptBackgroundLibrary() {
  return request({
    url: '/admin/baseData/getScriptBackgroundLibrary',//logintest /admin/auth/login
    method: 'get'
  })
}
export function getScriptDifficultyLibrary() {
  return request({
    url: '/admin/baseData/getScriptDifficultyLibrary',//logintest /admin/auth/login
    method: 'get'
  })
}
export function getScriptFormLibrary() {
  return request({
    url: '/admin/baseData/getScriptFormLibrary',//logintest /admin/auth/login
    method: 'get'
  })
}
export function getScriptThemeLibrary() {
  return request({
    url: '/admin/baseData/getScriptThemeLibrary',//logintest /admin/auth/login
    method: 'get'
  })
}
export function getScriptTypeLibrary() {
  return request({
    url: '/admin/baseData/getScriptTypeLibrary',//logintest /admin/auth/login
    method: 'get'
  })
}
