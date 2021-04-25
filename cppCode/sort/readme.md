|                             名称                             |                           数据对象                           |                            稳定性                            |                          时间复杂度                          |                        额外空间复杂度                        |                             描述                             |                                                              |
| :----------------------------------------------------------: | :----------------------------------------------------------: | :----------------------------------------------------------: | :----------------------------------------------------------: | :----------------------------------------------------------: | :----------------------------------------------------------: | ------------------------------------------------------------ |
|                             平均                             |                             最坏                             |                                                              |                                                              |                                                              |                                                              |                                                              |
|      [冒泡排序](https://zh.wikipedia.org/wiki/泡沫排序)      |                             数组                             | ![img](https://upload.wikimedia.org/wikipedia/commons/thumb/f/fb/Yes_check.svg/15px-Yes_check.svg.png) | {\displaystyle O(n^{2})}![O(n^{2})](https://wikimedia.org/api/rest_v1/media/math/render/svg/6cd9594a16cb898b8f2a2dff9227a385ec183392) | {\displaystyle O(1)}![O(1)](https://wikimedia.org/api/rest_v1/media/math/render/svg/e66384bc40452c5452f33563fe0e27e803b0cc21) | （无序区，有序区）。 从无序区透过交换找出最大元素放到有序区前端。 |                                                              |
|      [选择排序](https://zh.wikipedia.org/wiki/选择排序)      |                             数组                             | ![img](https://upload.wikimedia.org/wikipedia/commons/thumb/a/a2/X_mark.svg/15px-X_mark.svg.png) | {\displaystyle O(n^{2})}![O(n^{2})](https://wikimedia.org/api/rest_v1/media/math/render/svg/6cd9594a16cb898b8f2a2dff9227a385ec183392) | {\displaystyle O(1)}![O(1)](https://wikimedia.org/api/rest_v1/media/math/render/svg/e66384bc40452c5452f33563fe0e27e803b0cc21) | （有序区，无序区）。 在无序区里找一个最小的元素跟在有序区的后面。对数组：比较得多，换得少。 |                                                              |
|                             链表                             | ![img](https://upload.wikimedia.org/wikipedia/commons/thumb/f/fb/Yes_check.svg/15px-Yes_check.svg.png) |                                                              |                                                              |                                                              |                                                              |                                                              |
|      [插入排序](https://zh.wikipedia.org/wiki/插入排序)      |                          数组、链表                          | ![img](https://upload.wikimedia.org/wikipedia/commons/thumb/f/fb/Yes_check.svg/15px-Yes_check.svg.png) | {\displaystyle O(n^{2})}![O(n^{2})](https://wikimedia.org/api/rest_v1/media/math/render/svg/6cd9594a16cb898b8f2a2dff9227a385ec183392) | {\displaystyle O(1)}![O(1)](https://wikimedia.org/api/rest_v1/media/math/render/svg/e66384bc40452c5452f33563fe0e27e803b0cc21) | （有序区，无序区）。 把无序区的第一个元素插入到有序区的合适的位置。对数组：比较得少，换得多。 |                                                              |
|        [堆排序](https://zh.wikipedia.org/wiki/堆排序)        |                             数组                             | ![img](https://upload.wikimedia.org/wikipedia/commons/thumb/a/a2/X_mark.svg/15px-X_mark.svg.png) | {\displaystyle O(n\log n)}![O(n\log n)](https://wikimedia.org/api/rest_v1/media/math/render/svg/9d2320768fb54880ca4356e61f60eb02a3f9d9f1) | {\displaystyle O(1)}![O(1)](https://wikimedia.org/api/rest_v1/media/math/render/svg/e66384bc40452c5452f33563fe0e27e803b0cc21) | （最大堆，有序区）。 从堆顶把根卸出来放在有序区之前，再恢复堆。 |                                                              |
|      [归并排序](https://zh.wikipedia.org/wiki/归并排序)      |                             数组                             | ![img](https://upload.wikimedia.org/wikipedia/commons/thumb/f/fb/Yes_check.svg/15px-Yes_check.svg.png) | {\displaystyle O(n\log ^{2}n)}![{\displaystyle O(n\log ^{2}n)}](https://wikimedia.org/api/rest_v1/media/math/render/svg/48c36489701bc8023db2f8d6bc809b14a7f8dd4e) | {\displaystyle O(1)}![{\displaystyle O(1)}](https://wikimedia.org/api/rest_v1/media/math/render/svg/e66384bc40452c5452f33563fe0e27e803b0cc21) | 把数据分为两段，从两段中逐个选最小的元素移入新数据段的末尾。 可从上到下或从下到上进行。 |                                                              |
| {\displaystyle O(n\log n)}![O(n\log n)](https://wikimedia.org/api/rest_v1/media/math/render/svg/9d2320768fb54880ca4356e61f60eb02a3f9d9f1) | {\displaystyle O(n)+O(\log n)}![O(n)+O(\log n)](https://wikimedia.org/api/rest_v1/media/math/render/svg/e88d59c95a891d8f0e161659761f8e713f3f9e02) 如果不是从下到上 |                                                              |                                                              |                                                              |                                                              |                                                              |
|                             链表                             | {\displaystyle O(1)}![O(1)](https://wikimedia.org/api/rest_v1/media/math/render/svg/e66384bc40452c5452f33563fe0e27e803b0cc21) |                                                              |                                                              |                                                              |                                                              |                                                              |
|      [快速排序](https://zh.wikipedia.org/wiki/快速排序)      |                             数组                             | ![img](https://upload.wikimedia.org/wikipedia/commons/thumb/a/a2/X_mark.svg/15px-X_mark.svg.png) | {\displaystyle O(n\log n)}![O(n\log n)](https://wikimedia.org/api/rest_v1/media/math/render/svg/9d2320768fb54880ca4356e61f60eb02a3f9d9f1) | {\displaystyle O(n^{2})}![O(n^{2})](https://wikimedia.org/api/rest_v1/media/math/render/svg/6cd9594a16cb898b8f2a2dff9227a385ec183392) | {\displaystyle O(\log n)}![O(\log n)](https://wikimedia.org/api/rest_v1/media/math/render/svg/aae0f22048ba6b7c05dbae17b056bfa16e21807d) | （小数，基准元素，大数）。 在区间中随机挑选一个元素作基准，将小于基准的元素放在基准之前，大于基准的元素放在基准之后，再分别对小数区与大数区进行排序。 |
|                             链表                             | ![img](https://upload.wikimedia.org/wikipedia/commons/thumb/f/fb/Yes_check.svg/15px-Yes_check.svg.png) |                                                              |                                                              |                                                              |                                                              |                                                              |
|      [希尔排序](https://zh.wikipedia.org/wiki/希尔排序)      |                             数组                             | ![img](https://upload.wikimedia.org/wikipedia/commons/thumb/a/a2/X_mark.svg/15px-X_mark.svg.png) | {\displaystyle O(n\log ^{2}n)}![O(n\log ^{2}n)](https://wikimedia.org/api/rest_v1/media/math/render/svg/48c36489701bc8023db2f8d6bc809b14a7f8dd4e) | {\displaystyle O(n^{2})}![O(n^{2})](https://wikimedia.org/api/rest_v1/media/math/render/svg/6cd9594a16cb898b8f2a2dff9227a385ec183392) | {\displaystyle O(1)}![O(1)](https://wikimedia.org/api/rest_v1/media/math/render/svg/e66384bc40452c5452f33563fe0e27e803b0cc21) | 每一轮按照事先决定的间隔进行插入排序，间隔会依次缩小，最后一次一定要是1。 |
|                                                              |                                                              |                                                              |                                                              |                                                              |                                                              |                                                              |
|      [计数排序](https://zh.wikipedia.org/wiki/计数排序)      |                          数组、链表                          | ![img](https://upload.wikimedia.org/wikipedia/commons/thumb/f/fb/Yes_check.svg/15px-Yes_check.svg.png) | {\displaystyle O(n+m)}![O(n+m)](https://wikimedia.org/api/rest_v1/media/math/render/svg/5d103b38ce2abfde793118c89cd4fac5c956b89d) | {\displaystyle O(n+m)}![O(n+m)](https://wikimedia.org/api/rest_v1/media/math/render/svg/5d103b38ce2abfde793118c89cd4fac5c956b89d) | 统计小于等于该元素值的元素的个数i，于是该元素就放在目标数组的索引i位（i≥0）。 |                                                              |
|        [桶排序](https://zh.wikipedia.org/wiki/桶排序)        |                          数组、链表                          | ![img](https://upload.wikimedia.org/wikipedia/commons/thumb/f/fb/Yes_check.svg/15px-Yes_check.svg.png) | {\displaystyle O(n)}![O(n)](https://wikimedia.org/api/rest_v1/media/math/render/svg/34109fe397fdcff370079185bfdb65826cb5565a) | {\displaystyle O(m)}![O(m)](https://wikimedia.org/api/rest_v1/media/math/render/svg/a0ffd498cf521ce19814e6b7053f1f8ebb1d3c88) |     将值为i的元素放入i号桶，最后依次把桶里的元素倒出来。     |                                                              |
|      [基数排序](https://zh.wikipedia.org/wiki/基数排序)      |                          数组、链表                          | ![img](https://upload.wikimedia.org/wikipedia/commons/thumb/f/fb/Yes_check.svg/15px-Yes_check.svg.png) | {\displaystyle O(k\times n)}![O(k\times n)](https://wikimedia.org/api/rest_v1/media/math/render/svg/753ea58d397ba5729b620212cdeebe9601614737) | {\displaystyle O(n^{2})}![O(n^{2})](https://wikimedia.org/api/rest_v1/media/math/render/svg/6cd9594a16cb898b8f2a2dff9227a385ec183392) |                                                              | 一种多关键字的排序算法，可用桶排序实现。                     |