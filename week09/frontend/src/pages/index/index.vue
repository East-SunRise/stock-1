<template>
  <view class="container">
    <view class="header">
      <text class="title">Spring Boot API 测试</text>
    </view>
    
    <view class="content">
      <view class="card">
        <text class="card-title">公共接口测试</text>
        <button class="btn" @click="testPublicApi">请求公共接口</button>
        <view v-if="publicResult" class="result">
          <text class="result-title">响应结果:</text>
          <text class="result-content">{{ publicResult }}</text>
        </view>
      </view>

      <view class="card">
        <text class="card-title">认证接口测试 (admin-token)</text>
        <button class="btn btn-primary" @click="testAuthApi">请求认证接口</button>
        <view v-if="authResult" class="result">
          <text class="result-title">响应结果:</text>
          <text class="result-content">{{ authResult }}</text>
        </view>
      </view>

      <view class="card">
        <text class="card-title">管理员接口测试</text>
        <button class="btn btn-danger" @click="testAdminApi">请求管理员接口</button>
        <view v-if="adminResult" class="result">
          <text class="result-title">响应结果:</text>
          <text class="result-content">{{ adminResult }}</text>
        </view>
      </view>
    </view>
  </view>
</template>

<script setup lang="ts">
import { ref } from 'vue'

const publicResult = ref('')
const authResult = ref('')
const adminResult = ref('')

const BASE_URL = 'http://localhost:8080'

const testPublicApi = () => {
  publicResult.value = '请求中...'
  uni.request({
    url: `${BASE_URL}/api/public`,
    method: 'GET',
    success: (res) => {
      publicResult.value = JSON.stringify(res.data, null, 2)
      console.log('公共接口响应:', res.data)
    },
    fail: (err) => {
      publicResult.value = `请求失败: ${err.errMsg}`
      console.error('公共接口请求失败:', err)
    }
  })
}

const testAuthApi = () => {
  authResult.value = '请求中...'
  uni.request({
    url: `${BASE_URL}/api/test`,
    method: 'GET',
    header: {
      'Authorization': 'admin-token'
    },
    success: (res) => {
      authResult.value = JSON.stringify(res.data, null, 2)
      console.log('认证接口响应:', res.data)
    },
    fail: (err) => {
      authResult.value = `请求失败: ${err.errMsg}`
      console.error('认证接口请求失败:', err)
    }
  })
}

const testAdminApi = () => {
  adminResult.value = '请求中...'
  uni.request({
    url: `${BASE_URL}/api/admin`,
    method: 'GET',
    header: {
      'Authorization': 'admin-token'
    },
    success: (res) => {
      adminResult.value = JSON.stringify(res.data, null, 2)
      console.log('管理员接口响应:', res.data)
    },
    fail: (err) => {
      adminResult.value = `请求失败: ${err.errMsg}`
      console.error('管理员接口请求失败:', err)
    }
  })
}
</script>

<style lang="scss" scoped>
.container {
  min-height: 100vh;
  background-color: #f5f5f5;
  padding: 20rpx;
}

.header {
  text-align: center;
  padding: 40rpx 0;
}

.title {
  font-size: 48rpx;
  font-weight: bold;
  color: #333;
}

.content {
  display: flex;
  flex-direction: column;
  gap: 20rpx;
}

.card {
  background: #fff;
  border-radius: 16rpx;
  padding: 30rpx;
  box-shadow: 0 4rpx 20rpx rgba(0, 0, 0, 0.05);
}

.card-title {
  font-size: 32rpx;
  font-weight: 600;
  color: #333;
  margin-bottom: 20rpx;
}

.btn {
  width: 100%;
  height: 88rpx;
  line-height: 88rpx;
  text-align: center;
  background-color: #f0f0f0;
  color: #333;
  border-radius: 12rpx;
  font-size: 32rpx;
  border: none;
  margin-bottom: 20rpx;
  
  &:active {
    opacity: 0.7;
  }
  
  &.btn-primary {
    background-color: #409eff;
    color: #fff;
  }
  
  &.btn-danger {
    background-color: #f56c6c;
    color: #fff;
  }
}

.result {
  background-color: #f8f9fa;
  border-radius: 12rpx;
  padding: 20rpx;
}

.result-title {
  font-size: 28rpx;
  color: #666;
  display: block;
  margin-bottom: 10rpx;
}

.result-content {
  font-size: 26rpx;
  color: #333;
  white-space: pre-wrap;
  word-break: break-all;
}
</style>
