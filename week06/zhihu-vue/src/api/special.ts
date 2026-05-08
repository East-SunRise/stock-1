import { httpGet } from '../utils/http'
import type { SpecialItem, SpecialPageResult } from '../types/special'
import { normalizeItem, pickRows, pickTotal, pickOneRecord } from './specialNormalize'

/**
 * 分页获取专题列表
 * @param title 标题搜索关键词（可选）
 * @param pageNum 页码（默认 1）
 * @param pageSize 每页条数（默认 10）
 * @returns 分页结果
 */
export async function getSpecialList(
  title?: string,
  pageNum: number = 1,
  pageSize: number = 10,
): Promise<SpecialPageResult> {
  const params: Record<string, any> = {
    pageNum,
    pageSize,
  }
  if (title) {
    params.title = title
  }

  const data = await httpGet<any>('/api/v1/special/page', {
    params,
  })

  const rows = pickRows(data)
  const total = pickTotal(data)

  const list: SpecialItem[] = rows.map((item) => {
    const rec = item as Record<string, unknown>
    return normalizeItem(rec)
  })

  return {
    list,
    total,
  }
}

/**
 * 获取专题详情
 * @param id 专题 ID
 * @returns 专题详情
 */
export async function getSpecialDetail(id: string): Promise<SpecialItem | null> {
  const data = await httpGet<any>('/api/v1/special/detail', {
    params: { id },
  })

  const record = pickOneRecord(data)
  if (!record) return null

  return normalizeItem(record)
}