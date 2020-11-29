<template>
<!--  https://vuejsexamples.com/a-vue-component-of-dynamic-table/-->
  <div class="topic-container">
    <vue-table-dynamic
      :params="params"
      @select="onSelect"
      @selection-change="onSelectionChange"
      ref="table"
    />
  </div>
</template>

<script>
import VueTableDynamic from 'vue-table-dynamic';

export default {
  components: {
    VueTableDynamic
  },
  data() {
    return {
      params: {
        data: [
          ['id', 'topic', 'status', 'createdAt'],
          [1, 'news', 'Y', '2020-11-20T01:55:00']
        ],
        header: 'row',
        showCheck: true,
        border: true,
        stripe: true,
        pagination: true,
        pageSize: 5,
        pageSizes: [5, 10, 20, 50],
        enableSearch: true
      }
    }
  },
  methods: {
    onSelect (isChecked, index, data) {
      console.log('onSelect: ', isChecked, index, data)
      console.log('Checked Data:', this.$refs.table.getCheckedRowDatas(true))
    },
    onSelectionChange (checkedData, checkedIndices, checkedNum) {
      console.log('onSelectionChange: ', checkedData, checkedIndices, checkedNum)
    }
  }
}
</script>

<style lang="scss" scoped>
.topic-container {
  padding: 16px;
}
</style>
