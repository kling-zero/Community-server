const routes = [
  {
    path: 'parkingLotManagement',
    name: 'ParkingLotManagement',
    component: () =>
      import('@/views/pages/parking/ParkingLotManagement.vue')
  },
  {
    path: 'parkingSpaceInformation',
    name: 'ParkingSpaceInformation',
    component: () =>
      import('@/views/pages/parking/ParkingSpaceInformation.vue')
  },
  {
    path: 'sentryBoxManagement',
    name: 'SentryBoxManagement',
    component: () =>
      import('@/views/pages/parking/SentryBoxManagement.vue')
  },
  {
    path: 'ownerVehicle',
    name: 'OwnerVehicle',
    component: () =>
      import('@/views/pages/parking/OwnerVehicle.vue')
  },
  {
    path: 'mobilizationRecord',
    name: 'MobilizationRecord',
    component: () =>
      import('@/views/pages/parking/MobilizationRecord.vue')
  },
  {
    path: 'onSiteVehicles',
    name: 'OnSiteVehicles',
    component: () =>
      import('@/views/pages/parking/OnSiteVehicles.vue')
  },
  {
    path: 'authorizationInformation',
    name: 'AuthorizationInformation',
    component: () =>
      import('@/views/pages/parking/AuthorizationInformation.vue')
  },
  {
    path: 'RemainingParkingSpace',
    name: 'remainingParkingSpace',
    component: () =>
      import('@/views/pages/parking/RemainingParkingSpace.vue')
  },
  {
    path: 'parkingSpaceApplication',
    name: 'ParkingSpaceApplication',
    component: () =>
      import('@/views/pages/parking/ParkingSpaceApplication.vue')
  },
]

export default routes
