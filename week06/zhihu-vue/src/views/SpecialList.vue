<template>
  <div class="special-list">
    <div class="container">
      <div class="header">
        <h1>知乎专题</h1>
        <div class="search-box">
          <el-input
            v-model="searchTitle"
            placeholder="搜索专题"
            clearable
            @keyup.enter="handleSearch"
          >
            <template #append>
              <el-button @click="handleSearch">搜索</el-button>
            </template>
          </el-input>
        </div>
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

      <div v-else-if="list.length === 0" class="empty">
        <el-empty description="暂无专题数据" />
      </div>

      <div v-else class="list">
        <div v-for="item in list" :key="item.id" class="item">
          <div class="cover">
            <img
              :src="item.cover || coverPlaceholder(item.title)"
              :alt="item.title"
              @error="handleImageError($event, item)"
            />
          </div>
          <div class="info">
            <h2 class="title">
              <router-link :to="`/special/${item.id}`">{{ item.title }}</router-link>
            </h2>
            <p class="introduction">{{ item.introduction }}</p>
            <div class="meta">
              <span class="update">{{ item.updateLabel }}</span>
              <span class="visit">{{ item.visitLabel }}</span>
              <span class="followers">{{ item.followersLabel }}</span>
            </div>
          </div>
          <div class="action">
            <el-button
              :type="item.isFollowing ? 'info' : 'primary'"
              :plain="item.isFollowing"
            >
              {{ item.isFollowing ? '已关注' : '关注' }}
            </el-button>
          </div>
        </div>

        <div class="pagination">
          <el-pagination
            v-model:current-page="pageNum"
            v-model:page-size="pageSize"
            :page-sizes="[10, 20, 50]"
            layout="total, sizes, prev, pager, next, jumper"
            :total="total"
            @size-change="handleSizeChange"
            @current-change="handleCurrentChange"
          />
        </div>
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
import { ref, onMounted } from 'vue'
import { ElMessage } from 'element-plus'
import { getSpecialList } from '../api/special'
import { coverPlaceholder } from '../utils/coverPlaceholder'
import { axiosErrorMessage } from '../utils/httpError'
import type { SpecialItem } from '../types/special'

const searchTitle = ref('')
const list = ref<SpecialItem[]>([])
const total = ref(0)
const pageNum = ref(1)
const pageSize = ref(10)
const loading = ref(true)
const error = ref('')

async function loadData() {
  loading.value = true
  error.value = ''
  try {
    const result = await getSpecialList(searchTitle.value, pageNum.value, pageSize.value)
    list.value = result.list
    total.value = result.total
  } catch (e) {
    error.value = axiosErrorMessage(e, '加载专题列表失败')
    ElMessage.error(error.value)
  } finally {
    loading.value = false
  }
}

function handleSearch() {
  pageNum.value = 1
  loadData()
}

function handleSizeChange(size: number) {
  pageSize.value = size
  loadData()
}

function handleCurrentChange(current: number) {
  pageNum.value = current
  loadData()
}

function handleImageError(event: Event, item: SpecialItem) {
  const target = event.target as HTMLImageElement
  target.src = coverPlaceholder(item.title)
}

onMounted(() => {
  loadData()
})
</script>

<style scoped>
.special-list {
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
  justify-content: space-between;
  align-items: center;
  margin-bottom: 30px;
  padding-bottom: 20px;
  border-bottom: 1px solid #e8e8e8;
}

.header h1 {
  font-size: 24px;
  font-weight: 600;
  color: #333;
  margin: 0;
}

.search-box {
  width: 300px;
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

.list {
  background-color: #fff;
  border-radius: 4px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
  padding: 20px;
}

.item {
  display: flex;
  padding: 20px 0;
  border-bottom: 1px solid #f0f0f0;
}

.item:last-child {
  border-bottom: none;
}

.cover {
  flex-shrink: 0;
  width: 200px;
  height: 120px;
  margin-right: 20px;
  overflow: hidden;
  border-radius: 4px;
}

.cover img {
  width: 100%;
  height: 100%;
  object-fit: cover;
  transition: transform 0.3s ease;
}

.cover:hover img {
  transform: scale(1.05);
}

.info {
  flex: 1;
  min-width: 0;
}

.title {
  font-size: 18px;
  font-weight: 600;
  margin: 0 0 10px 0;
}

.title a {
  color: #333;
  text-decoration: none;
}

.title a:hover {
  color: #1890ff;
}

.introduction {
  font-size: 14px;
  color: #666;
  margin: 0 0 15px 0;
  line-height: 1.5;
  overflow: hidden;
  text-overflow: ellipsis;
  display: -webkit-box;
  -webkit-line-clamp: 2;
  -webkit-box-orient: vertical;
}

.meta {
  display: flex;
  font-size: 12px;
  color: #999;
}

.meta span {
  margin-right: 20px;
}

.action {
  flex-shrink: 0;
  display: flex;
  align-items: center;
  margin-left: 20px;
}

.pagination {
  margin-top: 30px;
  text-align: right;
}
</style>