// echarts v4.x 引入
import echarts from 'echarts/lib/echarts'
import 'echarts/lib/component/tooltip'
import 'echarts/lib/component/toolbox'
import 'echarts/lib/component/grid'
import 'echarts/lib/component/legend'
import 'echarts/lib/chart/pie'
import 'echarts/lib/chart/bar'
import 'echarts/lib/chart/line'

export default class ZOChart {
  constructor({ container, target, options, data }) {
    this.$container = container
    this.$target = target
    this.options = options
    this.data = data
    this.repeat = 1
    this.init()
  }

  static legendTextType = {
    light: {
      color: '#e3e3e3',
      fontSize: 14,
      padding: [0, 2]
    },
    dark: {
      color: '#3e3e3e',
      fontSize: 14,
      padding: [0, 2]
    }
  }

  static labelFont = {
    normal: {
      small: {
        fontSize: 14,
        fontWeight: 'bold'
      },
      medium: {
        fontSize: 18,
        fontWeight: 'bold'
      },
      large: {
        fontSize: 24,
        fontWeight: 'bold'
      }
    },
    emphasis: {
      small: {
        fontSize: 16,
        fontWeight: 'bold'
      },
      medium: {
        fontSize: 20,
        fontWeight: 'bold'
      },
      large: {
        fontSize: 26,
        fontWeight: 'bold'
      }
    }
  }

  static lineType = {
    short: {
      length: 12,
      length2: 10,
      lineStyle: {
        color: '#fff',
        width: 1
      }
    },
    middle: {
      length: 20,
      length2: 10,
      lineStyle: {
        color: '#fff',
        width: 2
      }
    },
    long: {
      length: 32,
      length2: 16,
      lineStyle: {
        color: '#fff',
        width: 3
      }
    }
  }

  static resetPos(pos) {
    return pos.reduce((acc, cur) => {
      const [key, val] = cur.split(' ')
      acc[key] = val
      return acc
    }, {})
  }

  init() {
    const {
      chartType,
      size,
      position,
      color,
      focus,
      toolbox,
      toolboxOrient,
      toolboxPos,
      legend,
      legendPos,
      legendOrient,
      legendText,
      label,
      labelSize,
      labelLine
    } = this.options
    const datasetOptions = this.handleData(chartType)
    const axisOptions = this.handleAxis(chartType, legendText)
    const tooltipOptions = this.handleTooltip(chartType)
    const toolboxOptions = this.handleToolbox(
      chartType,
      toolbox,
      toolboxPos,
      toolboxOrient
    )
    const legendOptions = this.handleLegend(
      chartType,
      legend,
      legendPos,
      legendOrient,
      legendText
    )
    const seriesOptions = this.handleSeries(
      chartType,
      size,
      position,
      focus,
      label,
      labelSize,
      labelLine
    )
    this.options = this.formatOptions({
      color,
      tooltipOptions,
      toolboxOptions,
      legendOptions,
      axisOptions,
      datasetOptions,
      seriesOptions
    })
    this.$target = echarts.init(this.$target)
    this.initContainer(size)
  }

  initContainer(size) {
    let [w, h] = size
    w = (w === 'auto' && 720) || w
    h = (h === 'auto' && 480) || h
    this.$container.style['width'] = w + 'px'
    this.$container.style['heigh'] = h + 'px'
  }

  formatOptions({
    color,
    tooltipOptions,
    toolboxOptions,
    legendOptions,
    axisOptions,
    datasetOptions,
    seriesOptions
  }) {
    const options = {
      color,
      tooltip: tooltipOptions,
      toolbox: toolboxOptions,
      legend: legendOptions,
      dataset: datasetOptions,
      series: seriesOptions
    }
    if (axisOptions) {
      options['xAxis'] = axisOptions.xAxis
      options['yAxis'] = axisOptions.yAxis
    }
    return options
  }

  handleTooltip(chartType) {
    if (chartType === 'bar') {
      return {
        trigger: 'axis',
        axisPointer: {
          type: 'shadow'
        }
      }
    }
    return {
      trigger: 'item'
    }
  }

  handleToolbox(chartType, toolbox, toolboxPos, toolboxOrient) {
    if (!toolbox) return { show: toolbox }
    return {
      show: toolbox,
      orient: toolboxOrient,
      ...ZOChart.resetPos(toolboxPos),
      feature: {
        dataView: { show: true, readOnly: false },
        magicType: {
          show: (chartType === 'bar' && true) || false,
          type: ['line', 'bar', 'stack']
        },
        restore: { show: true },
        saveAsImage: { show: true }
      }
    }
  }

  handleLegend(chartType, legend, legendPos, legendOrient, legendText) {
    if (chartType === 'bar') {
      legendOrient = 'horizontal'
      legendPos = ['top top', 'left center']
    }
    if (typeof legend === 'boolean' && legend === false) return { show: legend }
    legend = (typeof legend === 'boolean' && 'plain') || legend
    return {
      show: true,
      type: legend,
      orient: legendOrient,
      textStyle: ZOChart.legendTextType[legendText],
      ...ZOChart.resetPos(legendPos)
    }
  }

  handleAxis(chartType, legendText) {
    if (chartType !== 'bar') return null
    const textStyle = ZOChart.legendTextType[legendText]
    return {
      xAxis: {
        type: 'category',
        axisTick: { show: false },
        axisLine: {
          lineStyle: {
            color: textStyle['color']
          }
        }
      },
      yAxis: {
        type: 'value',
        axisLine: {
          lineStyle: {
            color: textStyle['color']
          }
        }
      }
    }
  }

  handleData(chartType) {
    let { dimensions, source } = this.data
    if (!dimensions) {
      dimensions = source.splice(0, 1)[0]
    }
    if (!(dimensions instanceof Array)) {
      dimensions = [dimensions, 'value']
    }
    if (dimensions.length < 2) {
      dimensions[1] = 'value'
    }
    if (chartType === 'bar') {
      this.repeat = dimensions.length - 1
    }
    return { dimensions, source }
  }

  handleLabel(label, labelFont, labelLine) {
    if (typeof label === 'boolean' && label === false) {
      return {
        labelOptions: { show: label },
        labelLineOptions: { show: label }
      }
    }
    label = (typeof label === 'boolean' && 'outside') || label
    labelLine =
      (typeof labelLine === 'boolean' && labelLine && 'middle') || labelLine
    labelLine = (labelLine && {
      show: true,
      ...ZOChart.lineType[labelLine]
    }) || { show: labelLine }
    return {
      labelOptions: {
        show: true,
        position: label,
        ...labelFont
      },
      labelLineOptions: labelLine
    }
  }

  handleSeries(chartType, size, position, focus, label, labelSize, labelLine) {
    const normalFont = ZOChart.labelFont['normal'][labelSize]
    const emphasisFont = ZOChart.labelFont['emphasis'][labelSize]
    const { labelOptions, labelLineOptions } = this.handleLabel(
      label,
      normalFont,
      labelLine
    )
    const options = []
    const data = {
      type: (chartType === 'circle' && 'pie') || chartType,
      avoidLabelOverlap: false,
      label: labelOptions,
      barGap: (chartType === 'bar' && '0') || null,
      emphasis: {
        focus:
          (focus && ((chartType === 'bar' && 'series') || 'self')) || 'none' // v4.x不生效
      }
    }
    if (chartType !== 'bar') {
      data['radius'] = (chartType === 'pie' && ['0%', '60%']) || ['25%', '60%']
      data['center'] = position
      data['width'] = size[0]
      data['height'] = size[1]
      data['labelLine'] = labelLineOptions
      data['emphasis']['scaleSize'] = 15 // v4.x不生效
      data['emphasis']['label'] = { show: true, ...emphasisFont }
      data['emphasis']['labelLine'] = labelLineOptions
    }
    for (let i = 0; i < this.repeat; i++) {
      options[i] = data
    }
    return options
  }

  render(options) {
    options = options || this.options
    this.$target.setOption(options)
  }
}
