import { createRouter, createWebHistory, RouteRecordRaw } from 'vue-router'

const routes: RouteRecordRaw[] = [
  {
    path: '/',
    redirect: '/special'
  },
  {
    path: '/special',
    name: 'SpecialList',
    component: () => import('../views/SpecialList.vue'),
    meta: {
      title: '知乎专题列表'
    }
  },
  {
    path: '/special/:id',
    name: 'SpecialDetail',
    component: () => import('../views/SpecialDetail.vue'),
    meta: {
      title: '知乎专题详情'
    }
  }
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

// 路由前置守卫，设置页面标题
router.beforeEach((to, from, next) => {
  if (to.meta.title) {
    document.title = to.meta.title as string
  }
  next()
})

export default router