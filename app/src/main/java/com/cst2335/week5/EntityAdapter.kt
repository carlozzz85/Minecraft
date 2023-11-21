package com.cst2335.week5

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class EntityAdapter(private val context: Context, private val entityList: List<Entity>) : BaseAdapter() {
    override fun getCount(): Int = entityList.size

    override fun getItem(position: Int): Any = entityList[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View{
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.entity_item,parent, false)
        val entityIcon: ImageView = view.findViewById(R.id.entityIcon)
        val entityName: TextView = view.findViewById(R.id.entityName)

        val entity = getItem(position) as Entity
        entityName.text = entity.name
        val iconName = "entity_${entity.type}"
        val resId = context.resources.getIdentifier(iconName,"drawable", context.packageName)
        entityIcon.setImageResource(resId)

        return view
    }

}