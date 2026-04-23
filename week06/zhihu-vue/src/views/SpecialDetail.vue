<template>
  <div class="special-detail">
    <div class="container">
      <div class="header">
        <el-button @click="$router.back()" icon="ArrowLeft">返回</el-button>
        <h1>专题详情</h1>
      </div>

      <div v-if="loading" class="loading">
        <el-skeleton :rows="10" animated />
      </div>

      <div v-else-if="error" class="error">
        <el-alert
          :title="error"
          type="error"
          show-icon
          :closable="false"
        />
        <el-button type="primary" @click="loadData">重试</el-button>
      </div>

      <div v-else-if="!special" class="empty">
        <el-empty description="专题不存在" />
      </div>

      <div v-else class="detail">
        <div class="banner">
          <img
            :src="special.cover || coverPlaceholder(special.title, 1200, 400)"
            :alt="special.title"
            @error="handleImageError"
          />
        </div>

        <div class="content">
          <h2 class="title">{{ special.title }}</h2>
          <div class="meta">
            <span class="update">{{ special.updateLabel }}</span>
            <span class="visit">{{ special.visitLabel }}</span>
            <span class="followers">{{ special.followersLabel }}</span>
          </div>
          <div class="introduction">{{ special.introduction }}</div>
          <div class="action">
            <el-button
              :type="special.isFollowing ? 'info' : 'primary'"
              :plain="special.isFollowing"
              size="large"
            >
              {{ special.isFollowing ? '已关注' : '关注' }}
            </el-button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
import { ref, onMounted } from 'vue'
import { useRoute } from 'vue-router'
import { ElMessage } from 'element-plus'
import { getSpecialDetail } from '../api/special'
import { coverPlaceholder } from '../utils/coverPlaceholder'
import { axiosErrorMessage } from '../utils/httpError'
import type { SpecialItem } from '../types/special'

const route = useRoute()
const special = ref<SpecialItem | null>(null)
const loading = ref(true)
const error = ref('')

async function loadData() {
  loading.value = true
  error.value = ''
  try {
    const id = route.params.id as string
    const data = await getSpecialDetail(id)
    special.value = data
  } catch (e) {
    error.value = axiosErrorMessage(e, '加载专题详情失败')
    ElMessage.error(error.value)
  } finally {
    loading.value = false
  }
}

function handleImageError(event: Event) {
  const target = event.target as HTMLImageElement
  if (special.value) {
    target.src = coverPlaceholder(special.value.title, 1200, 400)
  }
}

onMounted(() => {
  loadData()
})
</script>

<style scoped>
.special-detail {
  min-height: 100vh;
  background-color: #f5f5f5;
  padding: 20px 0;
}

.container {
  max-width: 1200px;
  margin: 0 auto;
  padding: 0 20px;
}

.header {
  display: flex;
  align-items: center;
  margin-bottom: 30px;
  padding-bottom: 20px;
  border-bottom: 1px solid #e8e8e8;
}

.header h1 {
  font-size: 24px;
  font-weight: 600;
  color: #333;
  margin: 0 0 0 20px;
}

.loading {
  background-color: #fff;
  padding: 20px;
  border-radius: 4px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
}

.error {
  background-color: #fff;
  padding: 20px;
  border-radius: 4px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
  text-align: center;
}

.error .el-button {
  margin-top: 20px;
}

.empty {
  background-color: #fff;
  padding: 60px 20px;
  border-radius: 4px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
  text-align: center;
}

.detail {
  background-color: #fff;
  border-radius: 4px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
  overflow: hidden;
}

.banner {
  width: 100%;
  height: 400px;
  overflow: hidden;
}

.banner img {
  width: 100%;
  height: 100%;
  object-fit: cover;
}

.content {
  padding: 30px;
}

.title {
  font-size: 24px;
  font-weight: 600;
  color: #333;
  margin: 0 0 20px 0;
}

.meta {
  display: flex;
  font-size: 14px;
  color: #999;
  margin-bottom: 20px;
}

.meta span {
  margin-right: 30px;
}

.introduction {
  font-size: 16px;
  line-height: 1.6;
  color: #666;
  margin-bottom: 30px;
  white-space: pre-wrap;
}

.action {
  display: flex;
  justify-content: center;
}
</style>