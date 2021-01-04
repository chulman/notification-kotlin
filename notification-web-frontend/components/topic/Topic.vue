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
import { mapActions, mapMutations } from "vuex";

export default {
  components: {
    VueTableDynamic
  },
  mounted() {
    this.getAll('/api/v1/topic/list')
      .then(response => {
        response.forEach(data => {
          const row = [data.id, data.topic, data.status, data.createdAt, data.updatedAt];
          this.params.data.push(row);
        })
      })
      .catch(e => {
        console.error(e);
      });
  },
  data() {
    return {
      params: {
        data: [['id', 'topic', 'status', 'createdAt', 'updatedAt']],
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
    ...mapActions('topic', {
      getAll: 'getAll'
    }),
    ...mapMutations('topic', {
      setSelectedTopic: 'setSelectedTopic'
    }),
    onSelect(isChecked, index, data) {
      const checkedRowDatas = this.$refs.table.getCheckedRowDatas(true);
      // console.log('onSelect: ', isChecked, index, data, checkedRowDatas)
    },
    onSelectionChange(checkedData, checkedIndices, checkedNum) {
      // console.log('onSelectionChange: ', checkedIndices, checkedNum)
      if (checkedData.length > 1) {
        const selectedArray = checkedData.filter((data, index) => index !== 0)
          .map(data => data[1])
        this.setSelectedTopic(selectedArray);
      } else {
        this.setSelectedTopic([]);
      }
    }
  }
}
</script>

<style lang="scss" scoped>
.topic-container {
  padding: 16px;
}
</style>
