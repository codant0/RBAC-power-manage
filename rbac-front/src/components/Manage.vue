<template>
    <el-tabs v-model="activeName" @tab-click="handleClick">
        <el-tab-pane label="用户管理" name="first"></el-tab-pane>
        <el-tab-pane label="角色管理" name="second"></el-tab-pane>
        <el-tab-pane label="权限管理" name="third"></el-tab-pane>
    </el-tabs>
</template>

<script>
    export default {
        data() {
            return {
                activeName: 'second'
            };
        },
        methods: {
            handleClick(tab, event) {
                console.log(tab, event);
            }
        }
    };
</script>

<style scoped>

</style>
